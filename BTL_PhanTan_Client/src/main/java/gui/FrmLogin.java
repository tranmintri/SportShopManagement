package gui;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.TaiKhoanService;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class FrmLogin extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JTextField txtMatKhau;
	private JPasswordField passwordField;
	private JLabel lblTieuDe;
	private JButton btnDangNhap;
	private JPanel panel_UserIcon;
	private JLabel lbl_UserIcon;
	private JPanel panel_PassIcon;
	private JLabel lbl_PassIcon;
	public static TaiKhoan taiKhoanDangNhap;
	private TaiKhoanService taiKhoanService;
	private int port;
	private String host;
	private JPanel panel_HinhAnh;
	private JLabel lblHinhAnh;
	// public static NhanVien nv;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public int GetMaxWidth() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	}

	public int GetMaxHeight() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}

	// set the MAXIMUM size....

	public FrmLogin(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {
		this.port = port;
		this.host = host;
		taiKhoanService = (TaiKhoanService) Naming.lookup("rmi://"+host+":" + port + "/taiKhoanService");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setSize();
		setBounds(GetMaxWidth() / 4, GetMaxHeight() / 4, 965, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTieuDe = new JLabel("HỆ THỐNG QUẢN LÝ CỬA HÀNG THỂ THAO");
		lblTieuDe.setBackground(SystemColor.controlShadow);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.YELLOW);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTieuDe.setBounds(0, 0, 944, 55);
		contentPane.add(lblTieuDe);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setBackground(new Color(255, 127, 80));
		btnDangNhap.setBounds(690, 344, 137, 48);
		contentPane.add(btnDangNhap);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTenDangNhap.setForeground(new Color(255, 255, 0));
		txtTenDangNhap.setBackground(new Color(255, 127, 80));
		txtTenDangNhap.setText("tk0001");

		txtTenDangNhap.setBounds(650, 136, 262, 55);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMatKhau.setForeground(new Color(255, 255, 0));
		txtMatKhau.setBackground(new Color(255, 127, 80));
		txtMatKhau.setText("admin");
		txtMatKhau.setBounds(650, 236, 262, 55);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);

		panel_UserIcon = new JPanel();
		panel_UserIcon.setBackground(new Color(255, 127, 80));
		panel_UserIcon.setBounds(591, 136, 61, 55);
		contentPane.add(panel_UserIcon);
		panel_UserIcon.setLayout(null);

		lbl_UserIcon = new JLabel("");
		lbl_UserIcon.setForeground(new Color(0, 0, 0));
		lbl_UserIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_UserIcon.setIcon(new ImageIcon(FrmLogin.class.getResource("/gui/icon/woman.png")));
		lbl_UserIcon.setBounds(10, 11, 41, 33);

		// lblBackGround.setIcon(new
		// ImageIcon(Pn_TrangChu.class.getResource("/gui/icon/background.jpg")));

		panel_UserIcon.add(lbl_UserIcon);

		panel_PassIcon = new JPanel();
		panel_PassIcon.setBackground(new Color(255, 127, 80));
		panel_PassIcon.setBounds(592, 236, 60, 55);
		contentPane.add(panel_PassIcon);
		panel_PassIcon.setLayout(null);

		lbl_PassIcon = new JLabel("");
		lbl_PassIcon.setBackground(SystemColor.inactiveCaption);
		lbl_PassIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PassIcon.setIcon(new ImageIcon(FrmLogin.class.getResource("/gui/icon/lock.png")));
		lbl_PassIcon.setBounds(10, 11, 40, 33);
		panel_PassIcon.add(lbl_PassIcon);
		
		panel_HinhAnh = new JPanel();
		panel_HinhAnh.setBounds(10, 67, 571, 405);
		contentPane.add(panel_HinhAnh);
		panel_HinhAnh.setLayout(null);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(0, 0, 571, 405);
		panel_HinhAnh.add(lblHinhAnh);
		File file = new File("");
 		lblHinhAnh.setIcon(ResizeImage(file.getAbsolutePath() + "//src//main//java//gui///icon///bg3.jpg"));
		btnDangNhap.addActionListener(this);
		btnDangNhap.addMouseListener(this);
		contentPane.addMouseListener(new MouseListener() {

			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (txtMatKhau.getText().isEmpty()) {
					txtMatKhau.setText("Mật khẩu");
				}
				if (txtTenDangNhap.getText().isEmpty()) {
					txtTenDangNhap.setText("Tên đăng nhập");
				}
			}

			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtMatKhau.addMouseListener(new MouseListener() {

			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (txtMatKhau.getText().equals("Mật khẩu")) {
					txtMatKhau.setText("");
				}

			}

			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		txtTenDangNhap.addMouseListener(new MouseListener() {

			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method st
				if (txtTenDangNhap.getText().trim().equals("Tên đăng nhập")) {
					txtTenDangNhap.setText("");
				}
			}

			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDangNhap)) {
			String matKhau = txtMatKhau.getText().toString();
			System.out.println(matKhau);
			List<TaiKhoan> listTK = null;
			try {
				listTK = taiKhoanService.getAllTaiKhoan();
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			for (TaiKhoan taiKhoan : listTK) {
				if (taiKhoan.getTenTaiKhoan().toLowerCase()
						.equalsIgnoreCase(txtTenDangNhap.getText().toString().trim().toLowerCase())) {

					if (taiKhoan.getMatKhau().toLowerCase().equalsIgnoreCase(matKhau.toLowerCase())) {
						JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
						taiKhoanDangNhap = new TaiKhoan();
						taiKhoanDangNhap = taiKhoan;
						try {
							this.setVisible(false);
							new FrmQuanLy(port,host).setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						return;
					} else {
						JOptionPane.showMessageDialog(this, "Sai mật khẩu");
						return;
					}
				}

			}
			JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
		}

	}

	public TaiKhoan getTaiKhoanDangNhapThanhCong() {

		return taiKhoanDangNhap;
	}

	private void hoverIn(JButton button) {
		// System.out.println("in ok");
		button.setBackground(new Color(255, 255, 0));
		button.setForeground(new Color(128, 0, 0));
	}

	private void hoverOut(JButton button) {
		// System.out.println("in ok");
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(new Color(255, 255, 0));
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			hoverIn(btnDangNhap);
		}

	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			hoverOut(btnDangNhap);
		}

	}
	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon myImage = new ImageIcon(imgPath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(panel_HinhAnh.getWidth(), panel_HinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}

}
