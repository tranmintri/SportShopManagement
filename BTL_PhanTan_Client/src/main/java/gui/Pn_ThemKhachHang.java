package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.Color;
import javax.swing.SwingConstants;

import bus.KhachHangService;
import entity.KhachHang;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Pn_ThemKhachHang extends JFrame implements ActionListener {
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtEmail;
	private JTextField txtSdt;
	private KhachHangService khachHangService;
	private JButton btnThem;
	private JComboBox<Object> cb_GioiTinh;

	/**
	 * Create the panel.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Pn_ThemKhachHang(int port, String host, String sdt)
			throws MalformedURLException, RemoteException, NotBoundException {

		khachHangService = (KhachHangService) Naming.lookup("rmi://" + host + ":" + port + "/khachHangService");

		setSize(500, 568);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		txtMa = new JTextField();
		txtMa.setHorizontalAlignment(SwingConstants.CENTER);
		txtMa.setForeground(Color.BLACK);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMa.setEditable(false);
		txtMa.setColumns(10);
		txtMa.setBounds(168, 160, 267, 33);
		getContentPane().add(txtMa);

		String idPrefix = "KH";
		int length;
		try {
			length = khachHangService.getAllKhachHang().size();
			String finalId = idPrefix + String.format("%04d", length + 1);
			txtMa.setText(finalId);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		txtTen = new JTextField();
		txtTen.setHorizontalAlignment(SwingConstants.CENTER);
		txtTen.setForeground(Color.BLACK);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(168, 210, 267, 33);
		getContentPane().add(txtTen);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(168, 260, 267, 33);
		getContentPane().add(txtEmail);

		txtSdt = new JTextField();
		txtSdt.setHorizontalAlignment(SwingConstants.CENTER);
		txtSdt.setForeground(Color.BLACK);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSdt.setEditable(false);
		txtSdt.setColumns(10);
		txtSdt.setBounds(168, 310, 267, 33);
		getContentPane().add(txtSdt);

		cb_GioiTinh = new JComboBox<Object>(new Object[] {});
		cb_GioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cb_GioiTinh.setSelectedIndex(0);
		cb_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_GioiTinh.setEditable(true);
		cb_GioiTinh.setBounds(168, 360, 267, 33);
		getContentPane().add(cb_GioiTinh);

		JLabel lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaKhachHang.setBounds(37, 160, 121, 33);
		getContentPane().add(lblMaKhachHang);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKhachHang.setBounds(37, 210, 121, 33);
		getContentPane().add(lblTenKhachHang);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(37, 260, 121, 33);
		getContentPane().add(lblEmail);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT.setBounds(37, 310, 121, 33);
		getContentPane().add(lblSDT);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setBounds(37, 360, 121, 33);
		getContentPane().add(lblGioiTinh);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 489, 64);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00EAm Kh\u00E1ch H\u00E0ng");
		lblNewLabel.setBounds(0, 0, 479, 64);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(203, 459, 96, 33);
		getContentPane().add(btnThem);

		btnThem.addActionListener(this);
		txtSdt.setText(sdt);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();

		if (object.equals(btnThem)) {
			String ma = txtMa.getText();
			String ten = txtTen.getText();
			String email = txtEmail.getText();
			String sdt = txtSdt.getText();
			boolean gioiTinh = cb_GioiTinh.getSelectedItem().toString() == "Nam" ? false : true;
			
			KhachHang khachHang = new KhachHang(ma, ten, email, sdt, gioiTinh);
			
			try {
				if(khachHangService.addKhachHang(khachHang)) {
					JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
					this.setVisible(false);
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
