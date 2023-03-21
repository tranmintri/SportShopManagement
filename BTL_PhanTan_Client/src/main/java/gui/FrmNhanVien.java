package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmNhanVien extends JFrame  implements MouseListener{
	private boolean flag_TK = false;
	private boolean flag_HD = false;
	private JPanel contentPane;
	private JPanel panelTrangChu;
	private JLabel lblHomeIcon;
	private JPanel panelKhachHang;
	private JLabel lblKhachHangIcon;
	private JPanel panelHoaDon;
	private JLabel lblHoaDonIcon;
	private JPanel panelSanPham;
	private JLabel lblSanPhamIcon;
	private JPanel panelThongKe;
	private JLabel lblThongKeIcon;
	private JPanel panelTroGiup;
	private JLabel lblTroGiupIcon;
	private JPanel panelTaiKhoan;
	private JLabel lblTaiKhoanIcon;
	private JPanel panelDoiMatKhau;
	private JLabel lblDoiMatKhau;
	private JPanel panelDangXuat;
	private JLabel lblDangXuat;
	private JPanel panelMenuHoaDon;
	private JPanel panelTaoHoaDonMoi;
	private JLabel lbl_HoaDonMoi;
	private JPanel panelQuanLyHoaDon;
	private JLabel lblQuanLyHoaDon;
	private JPanel panelTenNV;
	private JLabel lblTenNV;
//	private Pn_ThongKeNhanVien pnThongKe;
	private Pn_QuanLyKhachHang pn_QuanLyKhachHang;
	private Pn_QuanLySanPham pn_QuanLySanPham;
	private NhanVien nv;
	private Pn_TrangChu pn_TrangChu;
//	private Pn_ThongKeNhanVien pn_ThongKe;
	private Pn_TaoHoaDon pn_TaoHoaDon;
	private Frm_DoiMatKhau frm_DoiMatKhau;
	private FrmLogin frm_Login;
	//private static FrmNhanVien frame;
	private JPanel panelMenuTaiKhoan;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					frame = new FrmNhanVien();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public int GetMaxWidth() {
		return 1536;
	}

	public int GetMaxHeight() {
		return 816;
	}

	public FrmNhanVien(int port, String host) throws Exception{
		frm_Login = new FrmLogin(port, host);
		setSize(1536, 816);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("QUAN LY HIEU SACH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 1109, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setBounds(0,0, 1536, 816);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// home
		panelTrangChu = new JPanel();
		panelTrangChu.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelTrangChu.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelTrangChu);
		panelTrangChu.setLayout(null);

		lblHomeIcon = new JLabel("Trang chủ");
		lblHomeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/house.png")));
		lblHomeIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelTrangChu.add(lblHomeIcon);
		// khachhang
		panelKhachHang = new JPanel();
		panelKhachHang.setLayout(null);
		panelKhachHang.setBounds(GetMaxWidth() / 7, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelKhachHang.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelKhachHang);

		lblKhachHangIcon = new JLabel("Quản lý khách hàng");
		lblKhachHangIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHangIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/rating.png")));
		lblKhachHangIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelKhachHang.add(lblKhachHangIcon);
		// hoadon
		panelHoaDon = new JPanel();
		panelHoaDon.setLayout(null);
		panelHoaDon.setBounds(GetMaxWidth() * 2 / 7, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelHoaDon.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelHoaDon);

		lblHoaDonIcon = new JLabel("Quản lý hóa đơn");
		lblHoaDonIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDonIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/package.png")));
		lblHoaDonIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelHoaDon.add(lblHoaDonIcon);
		// sanpham
		panelSanPham = new JPanel();
		panelSanPham.setLayout(null);
		panelSanPham.setBounds(GetMaxWidth() * 3 / 7, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelSanPham.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelSanPham);

		lblSanPhamIcon = new JLabel("Quản lý sản phẩm");
		lblSanPhamIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanPhamIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/product.png")));
		lblSanPhamIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelSanPham.add(lblSanPhamIcon);
		// thongke
		panelThongKe = new JPanel();
		panelThongKe.setLayout(null);
		panelThongKe.setBounds(GetMaxWidth() * 4 / 7, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelThongKe.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelThongKe);

		lblThongKeIcon = new JLabel("Thống kê");
		lblThongKeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/pie-chart.png")));
		lblThongKeIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelThongKe.add(lblThongKeIcon);

		// trogiup
		panelTroGiup = new JPanel();
		panelTroGiup.setLayout(null);
		panelTroGiup.setBounds(GetMaxWidth() * 5 / 7, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelTroGiup.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelTroGiup);

		lblTroGiupIcon = new JLabel("Trợ giúp");
		lblTroGiupIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTroGiupIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/help-desk.png")));
		lblTroGiupIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelTroGiup.add(lblTroGiupIcon);
		// taikhoan
		panelTaiKhoan = new JPanel();
		panelTaiKhoan.setLayout(null);
		panelTaiKhoan.setBounds(GetMaxWidth() * 6 / 7, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelTaiKhoan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(panelTaiKhoan);

		lblTaiKhoanIcon = new JLabel("Tài khoản");
		lblTaiKhoanIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoanIcon.setIcon(new ImageIcon(FrmQuanLy.class.getResource("/gui/icon/user.png")));
		lblTaiKhoanIcon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 20);
		panelTaiKhoan.add(lblTaiKhoanIcon);
		// menu taikhoan
		 panelMenuTaiKhoan = new JPanel();
		panelMenuTaiKhoan.setBounds(GetMaxWidth() * 6 / 7, GetMaxHeight() / 20, GetMaxWidth() / 7, GetMaxHeight() / 16);
		contentPane.add(panelMenuTaiKhoan);
		panelMenuTaiKhoan.setLayout(null);

		panelDoiMatKhau = new JPanel();
		panelDoiMatKhau.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelMenuTaiKhoan.add(panelDoiMatKhau);
		panelDoiMatKhau.setLayout(null);
		panelDoiMatKhau.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelDoiMatKhau.add(lblDoiMatKhau);
		lblDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);

		panelDangXuat = new JPanel();
		panelDangXuat.setBounds(0, GetMaxHeight() / 32, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelMenuTaiKhoan.add(panelDangXuat);
		panelDangXuat.setLayout(null);
		panelDangXuat.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelDangXuat.add(lblDangXuat);
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		// menu hoadon
		panelMenuHoaDon = new JPanel();
		panelMenuHoaDon.setLayout(null);
		panelMenuHoaDon.setBounds(GetMaxWidth() * 2 / 7, GetMaxHeight() / 20, GetMaxWidth() / 7, GetMaxHeight() / 16);
		contentPane.add(panelMenuHoaDon);

		panelTaoHoaDonMoi = new JPanel();
		panelTaoHoaDonMoi.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelMenuHoaDon.add(panelTaoHoaDonMoi);
		panelTaoHoaDonMoi.setLayout(null);
		panelTaoHoaDonMoi.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		lbl_HoaDonMoi = new JLabel("Tạo hóa đơn mới");
		lbl_HoaDonMoi.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelTaoHoaDonMoi.add(lbl_HoaDonMoi);
		lbl_HoaDonMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HoaDonMoi.setFont(new Font("Tahoma", Font.BOLD, 11));

		panelQuanLyHoaDon = new JPanel();
		panelQuanLyHoaDon.setBounds(0, GetMaxHeight() / 32, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelMenuHoaDon.add(panelQuanLyHoaDon);
		panelQuanLyHoaDon.setLayout(null);
		panelQuanLyHoaDon.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		lblQuanLyHoaDon = new JLabel("Quản lí hóa đơn");
		lblQuanLyHoaDon.setBounds(0, 0, GetMaxWidth() / 7, GetMaxHeight() / 32);
		panelQuanLyHoaDon.add(lblQuanLyHoaDon);
		lblQuanLyHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));

		panelTenNV = new JPanel();
		panelTenNV.setBackground(Color.CYAN);
		panelTenNV.setBounds(1138, 51, 162, 40);
		contentPane.add(panelTenNV);
		panelTenNV.setLayout(null);

		lblTenNV = new JLabel("Ten  NV");
		lblTenNV.setBounds(0, 0, 162, 40);
		panelTenNV.add(lblTenNV);
		lblTenNV.setBackground(Color.CYAN);
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNV.setHorizontalAlignment(SwingConstants.CENTER);


		
		
//		pn_ThongKe = new Pn_ThongKeNhanVien();
//		pn_ThongKe.setBounds(10, 102, 1493, 655);
//		getContentPane().add(pn_ThongKe);
//		pn_ThongKe.setVisible(false);

		pn_QuanLyKhachHang = new Pn_QuanLyKhachHang(port,host);
		pn_QuanLyKhachHang.setBounds(10, 102, 1493, 655);
		getContentPane().add(pn_QuanLyKhachHang);
		pn_QuanLyKhachHang.setVisible(false);

		pn_QuanLySanPham = new Pn_QuanLySanPham(port,host);
		pn_QuanLySanPham.setBounds(0, 102, 1493, 655);
		getContentPane().add(pn_QuanLySanPham);
		pn_QuanLySanPham.setVisible(false);


		pn_TrangChu = new Pn_TrangChu(port);
		pn_TrangChu.setBounds(0, 102, 1570, 675);
		getContentPane().add(pn_TrangChu);
		pn_TrangChu.setVisible(true);

		pn_TaoHoaDon = new Pn_TaoHoaDon(port,host);
		pn_TaoHoaDon.setBounds(0, 102, 1510, 675);
		getContentPane().add(pn_TaoHoaDon);
		pn_TaoHoaDon.setVisible(false);

		frm_DoiMatKhau = new Frm_DoiMatKhau(port,host);
		frm_DoiMatKhau.setVisible(false);

		
		// hienthiten
		FrmLogin dangNhap = new FrmLogin(port,host);
		TaiKhoan taiKhoan = dangNhap.getTaiKhoanDangNhapThanhCong();
		// System.out.println(taiKhoan);
		
		
		panelMenuHoaDon.setVisible(false);
		panelMenuTaiKhoan.setVisible(false);
		
		
		panelDangXuat.addMouseListener(this);
		panelDoiMatKhau.addMouseListener(this);
		panelTaoHoaDonMoi.addMouseListener(this);
		panelTroGiup.addMouseListener(this);
		
		panelThongKe.addMouseListener(this);
		panelSanPham.addMouseListener(this);
		panelKhachHang.addMouseListener(this);
		panelTrangChu.addMouseListener(this);
		contentPane.addMouseListener(this);
		
		panelTaiKhoan.addMouseListener(this);
		//lblTaiKhoanIcon.addMouseListener(this);
		
		panelHoaDon.addMouseListener(this);
		
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if(o.equals(panelDangXuat)) {
//			
//		}
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Object o = e.getSource();
		if(o.equals(panelDangXuat)) {
			this.setVisible(false);
			frm_Login.setVisible(true);
		}
		if(o.equals(panelDoiMatKhau)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuTaiKhoan.setVisible(false);
			panelMenuHoaDon.setVisible(false);
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			frm_DoiMatKhau.setVisible(true);
		}
		if(o.equals(panelTaoHoaDonMoi)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
	
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));

//			pn_ThongKe.setVisible(false);
			pn_QuanLyKhachHang.setVisible(false);
			pn_QuanLySanPham.setVisible(false);
			
			pn_TrangChu.setVisible(false);
			pn_TaoHoaDon.setVisible(true);
		}
		if(o.equals(panelTroGiup)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			// panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelTroGiup.setBackground(Color.LIGHT_GRAY);

//			pn_ThongKe.setVisible(false);
			pn_QuanLyKhachHang.setVisible(false);
			pn_QuanLySanPham.setVisible(false);
			
			pn_TrangChu.setVisible(false);
			pn_TaoHoaDon.setVisible(false);
		}

		if(o.equals(panelThongKe)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			// panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.LIGHT_GRAY);

//			pn_ThongKe.setVisible(true);
			pn_QuanLyKhachHang.setVisible(false);
			pn_QuanLySanPham.setVisible(false);
			
			pn_TrangChu.setVisible(false);
			pn_TaoHoaDon.setVisible(false);
		}
		if(o.equals(panelSanPham)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			// panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.LIGHT_GRAY);
//			pn_ThongKe.setVisible(false);
			pn_QuanLyKhachHang.setVisible(false);
			pn_QuanLySanPham.setVisible(true);
		
			pn_TrangChu.setVisible(false);
			pn_TaoHoaDon.setVisible(false);
		}
		if(o.equals(panelKhachHang)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);
			// panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelKhachHang.setBackground(Color.LIGHT_GRAY);

//			pn_ThongKe.setVisible(false);
			pn_QuanLyKhachHang.setVisible(true);
			pn_QuanLySanPham.setVisible(false);
		
			pn_TrangChu.setVisible(false);
		}
		if(o.equals(panelTrangChu)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			// panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.LIGHT_GRAY);

//			pn_ThongKe.setVisible(false);
			pn_QuanLyKhachHang.setVisible(false);
			pn_QuanLySanPham.setVisible(false);
			
			pn_TrangChu.setVisible(true);
			pn_TaoHoaDon.setVisible(false);
		}
		if(o.equals(contentPane)) {
			flag_HD = false;
			flag_TK = false;
			panelMenuHoaDon.setVisible(false);
			panelMenuTaiKhoan.setVisible(false);

			panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
			panelThongKe.setBackground(Color.getColor("#f0f0f0"));
			
			panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
			panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			panelSanPham.setBackground(Color.getColor("#f0f0f0"));
			panelTrangChu.setBackground(Color.getColor("#f0f0f0"));
		}
		if(o.equals(panelTaiKhoan)) {
			panelMenuTaiKhoan.setVisible(true);
			panelMenuHoaDon.setVisible(false);
		
			if (flag_TK == false) {
				flag_TK = true;
				panelMenuTaiKhoan.setVisible(true);
				panelTaiKhoan.setBackground(Color.LIGHT_GRAY);
				panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
				panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
				panelThongKe.setBackground(Color.getColor("#f0f0f0"));
				panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
				
				panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
				panelSanPham.setBackground(Color.getColor("#f0f0f0"));
				panelTrangChu.setBackground(Color.getColor("#f0f0f0"));

			} else {
				flag_TK = false;
				panelMenuTaiKhoan.setVisible(false);
				panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
			}
		}
		if(o.equals(panelHoaDon)) {
			panelMenuHoaDon.setVisible(true);
			panelMenuTaiKhoan.setVisible(false);
			if (flag_HD == false) {
				flag_HD = true;
				panelMenuHoaDon.setVisible(true);
				panelHoaDon.setBackground(Color.LIGHT_GRAY);
				panelTaiKhoan.setBackground(Color.getColor("#f0f0f0"));
				panelKhachHang.setBackground(Color.getColor("#f0f0f0"));
				panelThongKe.setBackground(Color.getColor("#f0f0f0"));
				
				panelTroGiup.setBackground(Color.getColor("#f0f0f0"));
				panelSanPham.setBackground(Color.getColor("#f0f0f0"));
				panelTrangChu.setBackground(Color.getColor("#f0f0f0"));

//				pn_ThongKe.setVisible(false);
//				pn_QuanLyKhachHang.setVisible(false);
//				pn_QuanLySanPham.setVisible(false);
//				
//				pn_TrangChu.setVisible(false);
//				pn_TaoHoaDon.setVisible(false);
			} else {
				flag_HD = false;
				panelMenuHoaDon.setVisible(false);
				panelHoaDon.setBackground(Color.getColor("#f0f0f0"));
			}
		}
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(panelTrangChu)) {
			hoverIn(panelTrangChu, lblHomeIcon);
		}
		if(o.equals(panelKhachHang)) {
			hoverIn(panelKhachHang, lblKhachHangIcon);
		}
		if(o.equals(panelHoaDon)) {
			hoverIn(panelHoaDon, lblHoaDonIcon);
		}
		if(o.equals(panelSanPham)) {
			hoverIn(panelSanPham, lblSanPhamIcon);
		}
		if(o.equals(panelThongKe)) {
			hoverIn(panelThongKe, lblThongKeIcon);
		}
		if(o.equals(panelTroGiup)) {
			hoverIn(panelTroGiup, lblTroGiupIcon);
		}
		if(o.equals(panelTaiKhoan)) {
			hoverIn(panelTaiKhoan, lblTaiKhoanIcon);
		}
		if(o.equals(panelQuanLyHoaDon)) {
			hoverIn(panelQuanLyHoaDon, lblQuanLyHoaDon);
		}
		if(o.equals(panelTaoHoaDonMoi)) {
			hoverIn(panelTaoHoaDonMoi, lblHoaDonIcon);
		}
		if(o.equals(panelDoiMatKhau)) {
			hoverIn(panelDoiMatKhau, lblDoiMatKhau);
		}
		if(o.equals(panelDangXuat)){
			hoverIn(panelDangXuat, lblDangXuat);
		}
		if(o.equals(panelQuanLyHoaDon)) {
			hoverIn(panelQuanLyHoaDon, lblQuanLyHoaDon);
		}
	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(panelTrangChu)) {
			hoverOut(panelTrangChu, lblHomeIcon);
		}
		if(o.equals(panelKhachHang)) {
			hoverOut(panelKhachHang, lblKhachHangIcon);
		}
		if(o.equals(panelHoaDon)) {
			hoverOut(panelHoaDon, lblHoaDonIcon);
		}
		if(o.equals(panelSanPham)) {
			hoverOut(panelSanPham, lblSanPhamIcon);
		}
		if(o.equals(panelThongKe)) {
			hoverOut(panelThongKe, lblThongKeIcon);
		}
		if(o.equals(panelTroGiup)) {
			hoverOut(panelTroGiup, lblTroGiupIcon);
		}
		if(o.equals(panelTaiKhoan)) {
			hoverOut(panelTaiKhoan, lblTaiKhoanIcon);
		}
		if(o.equals(panelQuanLyHoaDon)) {
			hoverOut(panelQuanLyHoaDon, lblQuanLyHoaDon);
		}
		if(o.equals(panelTaoHoaDonMoi)) {
			hoverOut(panelTaoHoaDonMoi, lblHoaDonIcon);
		}
		if(o.equals(panelDoiMatKhau)) {
			hoverOut(panelDoiMatKhau, lblDoiMatKhau);
		}
		if(o.equals(panelDangXuat)){
			hoverOut(panelDangXuat, lblDangXuat);
		}
		if(o.equals(panelQuanLyHoaDon)) {
			hoverOut(panelQuanLyHoaDon, lblQuanLyHoaDon);
		}
	}
	
    private void hoverIn(JPanel pn_Container, JLabel lbl_Title){
    	//System.out.println("in ok");
        pn_Container.setBackground(new Color(0,206,209));
        lbl_Title.setForeground(new Color(128,0,0));
    }
    
    private void hoverOut(JPanel pn_Container, JLabel lbl_Title){
    	//System.out.println("out ok");
        pn_Container.setBackground(new Color(240,240,240));
        lbl_Title.setForeground(new Color(0,0,0));
    }
}
