package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import bus.TaiKhoanService;
import entity.NhanVien;
import entity.TaiKhoan;

import java.awt.Color;

public class FrmThemTaiKhoan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField txtPass;
	private JPasswordField txtPassCfm;
	private JLabel lblTenDangNhap;
	private JLabel lblMatKhau;
	private JLabel lblXacNhanMK;
	private JButton btnTaoTaiKhoan;
	private JComboBox comboBoxQuyen;
	private JLabel lblLoaiTaiKhoan;
	private String matKhau;
	 private String host;
	 private int port;
	 private TaiKhoanService taiKhoanService;
	 private NhanVien nhanVien;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public FrmThemTaiKhoan(NhanVien nv, int port, String host) throws MalformedURLException, RemoteException, NotBoundException {
		
		this.nhanVien = nv;
		System.out.println(nv);
		this.port = port;
		this.host = host;
		
		taiKhoanService = (TaiKhoanService) Naming.lookup("rmi://"+host+":" + port + "/taiKhoanService");
		
		setResizable(false);
		setTitle("Tạo tài khoản\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 557, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		lblTenDangNhap = new JLabel("Tên đăng nhập: ");
		lblTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenDangNhap.setBounds(28, 63, 124, 19);
		contentPane.add(lblTenDangNhap);

		lblMatKhau = new JLabel("Mật khẩu: ");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatKhau.setBounds(28, 125, 91, 14);
		contentPane.add(lblMatKhau);

		lblXacNhanMK = new JLabel("Xác nhận mật khẩu: ");
		lblXacNhanMK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXacNhanMK.setBounds(28, 191, 158, 19);
		contentPane.add(lblXacNhanMK);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setBounds(245, 64, 210, 20);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setBounds(245, 124, 210, 20);
		contentPane.add(txtPass);

		txtPassCfm = new JPasswordField();
		txtPassCfm.setBounds(245, 192, 210, 20);
		contentPane.add(txtPassCfm);

		btnTaoTaiKhoan = new JButton("Tạo");
		btnTaoTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTaoTaiKhoan.setBounds(170, 266, 158, 35);
		contentPane.add(btnTaoTaiKhoan);

		comboBoxQuyen = new JComboBox();
		comboBoxQuyen.setBounds(245, 11, 210, 22);
		comboBoxQuyen.addItem("Quản lý");
		comboBoxQuyen.addItem("Nhân viên");
//		comboBoxQuyen.setSelectedItem(nv.isChucVu() == true ? "Quản lý" : "Nhân viên");
		comboBoxQuyen.setEditable(false);
		contentPane.add(comboBoxQuyen);

		lblLoaiTaiKhoan = new JLabel("Loại tài khoản: ");
		lblLoaiTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiTaiKhoan.setBounds(28, 11, 124, 22);
		contentPane.add(lblLoaiTaiKhoan);

		btnTaoTaiKhoan.addActionListener(this);
		String idPrefix = "TK";
		int length;
		try {
			length = taiKhoanService.getAllTaiKhoan().size();
			String finalId = idPrefix + String.format("%04d", length + 1);
			txtTenDangNhap.setText(finalId);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnTaoTaiKhoan)) {
			try {
				TaiKhoan taiKhoan = revertTaiKhoanFromTextfields();
				if (taiKhoanService.addTaiKhoan(taiKhoan)) {
					JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công");
					this.setVisible(false);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public TaiKhoan revertTaiKhoanFromTextfields() throws Exception{
		
		
		String tenDangNhap = txtTenDangNhap.getText().toString();
		
		char[] pass = txtPass.getPassword();
		String matKhau = new String(pass);
		System.out.println(matKhau);

		char[] passCfm = txtPassCfm.getPassword();
		String matKhauXacNhan = new String(passCfm);
		System.out.println(matKhauXacNhan);

		if (!matKhauXacNhan.trim().toLowerCase().equals(matKhau.trim().toLowerCase())) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp");
			txtPassCfm.requestFocus();
			return null;
		}
		
		int chucVu = comboBoxQuyen.getSelectedIndex();
		
		TaiKhoan taiKhoan = new TaiKhoan(tenDangNhap, matKhau, chucVu == 0 ? true:false, nhanVien);
		
		return taiKhoan;

	}
}
