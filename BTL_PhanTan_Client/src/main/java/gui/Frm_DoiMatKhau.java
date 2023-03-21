package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.TaiKhoanService;
import entity.NhanVien;
import entity.TaiKhoan;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Frm_DoiMatKhau extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblDoiMatKhau;
	private JLabel lblOldPass;
	private JLabel lblNewPass;
	private JLabel lblNewPassConfirm;
	private JButton btnDoi;
	private JButton btnThoat;
	private JPasswordField txtOldPass;
	private JPasswordField txtNewPass;
	private JPasswordField txtCfmNewPass;
	private NhanVien nv;
	private JLabel lblTenNV;
	private FrmLogin frmLogin;
	private TaiKhoan taiKhoan;
	private TaiKhoanService taiKhoanService;

	/**
	 * Launch the application.
	 */

	public Frm_DoiMatKhau(int port, String host) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		
		frmLogin = new FrmLogin(port, host);
		taiKhoan = frmLogin.getTaiKhoanDangNhapThanhCong();
		taiKhoanService = (TaiKhoanService) Naming.lookup("rmi://"+host+":" + port + "/taiKhoanService");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDoiMatKhau = new JLabel("ĐỔI MẬT KHẨU");
		lblDoiMatKhau.setForeground(new Color(255, 0, 0));
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDoiMatKhau.setBounds(0, 11, 525, 64);
		contentPane.add(lblDoiMatKhau);

		lblOldPass = new JLabel("Nhập mật khẩu cũ:");
		lblOldPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOldPass.setBounds(24, 89, 177, 14);
		contentPane.add(lblOldPass);

		lblNewPass = new JLabel("Nhập mật khẩu mới:");
		lblNewPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewPass.setBounds(24, 147, 177, 23);
		contentPane.add(lblNewPass);

		lblNewPassConfirm = new JLabel("Xác nhận mật khẩu mới:");
		lblNewPassConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewPassConfirm.setBounds(24, 218, 177, 14);
		contentPane.add(lblNewPassConfirm);

		btnDoi = new JButton("Đổi");
		btnDoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDoi.setBounds(112, 264, 89, 23);
		contentPane.add(btnDoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setBounds(300, 264, 89, 23);
		contentPane.add(btnThoat);

		txtOldPass = new JPasswordField();
		txtOldPass.setBounds(201, 86, 292, 20);
		contentPane.add(txtOldPass);

		txtNewPass = new JPasswordField();
		txtNewPass.setBounds(201, 149, 292, 20);
		contentPane.add(txtNewPass);

		txtCfmNewPass = new JPasswordField();
		txtCfmNewPass.setBounds(201, 215, 292, 20);
		contentPane.add(txtCfmNewPass);

		btnDoi.addActionListener(this);
		btnThoat.addActionListener(this);

		lblTenNV = new JLabel();
		contentPane.add(lblTenNV);

		// System.out.println(taiKhoan);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o.equals(btnThoat))
			this.setVisible(false);
		else if (o.equals(btnDoi)) {

			char[] pass = txtOldPass.getPassword();
			String matKhau = new String(pass);

			if (!taiKhoan.getMatKhau().toLowerCase().equals(matKhau)) {
				JOptionPane.showMessageDialog(this, "Mật khẩu cũ không chính xác");
				txtOldPass.requestFocus();
				return;
			}
			char[] newPass = txtNewPass.getPassword();
			String matKhauMoi = new String(newPass);

			char[] newPassCfm = txtCfmNewPass.getPassword();
			String matKhauMoiXacNhan = new String(newPassCfm);

			if (!matKhauMoiXacNhan.equalsIgnoreCase(matKhauMoi)) {
				JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp");
				txtCfmNewPass.requestFocus();
				return;
			}
			taiKhoan.setMatKhau(matKhauMoi);
			try {
				if (taiKhoanService.updateTaiKhoan(taiKhoan)) {
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
					this.setVisible(true);
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}
