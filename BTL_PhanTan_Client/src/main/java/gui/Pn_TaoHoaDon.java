package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import bus.ChatLieuService;
import bus.ChiTietHoaDonService;
import bus.HoaDonService;
import bus.KhachHangService;
import bus.MauSacService;
import bus.NhaCungCapService;
import bus.PhanLoaiService;
import bus.SanPhamService;
import bus.XuatXuService;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import entity.TaiKhoan;
import net.sf.jasperreports.data.FileDataAdapter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

public class Pn_TaoHoaDon extends JPanel implements ActionListener, MouseListener {

	private SanPhamService sanPhamService;
	private PhanLoaiService phanLoaiService;
	private ChatLieuService chatLieuService;
	private MauSacService mauSacService;
	private XuatXuService xuatXuService;
	private NhaCungCapService nhaCungCapService;
	private ChiTietHoaDonService chiTietHoaDonService;
	private HoaDonService hoaDonService;
	private KhachHangService khachHangService;

	private JTextField txtSDT;
	private JTextField txtTenKhachHang;
	private JTable tableSanPham;
	private JTextField txtTen;
	private JTextField txtGiaBan;
	private JComboBox cb_XuatXu;
	private JComboBox cb_MauSac;
	private JComboBox cb_ChatLieu;
	private JComboBox cb_NhaCungCap;
	private JComboBox cb_PhanLoai;
	private JButton btnTimKhachHang;
	private JTable tableHoaDon;
	private JTextField txtMaHoaDon;
	private JTextField txtTongTienHD;
	private JTextField txtNhanVien;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThua;
	private JButton btnThanhToan;
	private JButton btnXoa;
	private JButton btnThemSanPham;
	private DefaultTableModel modelSanPham;
	private JScrollPane scrollSach;
	private DefaultTableModel modelHoaDon;
	private JScrollPane scrollHoaDon;
	private String sdt;
	private String tenSP;
	// linh
	private JTextField txtMa;
	private JTextField txtSoLuongMua;
	private JTextField txtSoLuong;
	private JTextField txtMaTim;
	private JTextField txtTenTim;
	private JTextField txtSoLuongTru;
	private JTextField txtNgayLap;
	private JLabel lblMaHD;
	private long total = 0;
	private KhachHang khachHang;
	private int port;
	private String host;
	private int result;

	/**
	 * Create the panel.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */

	public Pn_TaoHoaDon(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {

		this.port = port;
		this.host = host;

		khachHangService = (KhachHangService) Naming.lookup("rmi://" + host + ":" + port + "/khachHangService");
		chiTietHoaDonService = (ChiTietHoaDonService) Naming
				.lookup("rmi://" + host + ":" + port + "/chiTietHoaDonService");
		hoaDonService = (HoaDonService) Naming.lookup("rmi://" + host + ":" + port + "/hoaDonService");
		sanPhamService = (SanPhamService) Naming.lookup("rmi://" + host + ":" + port + "/sanPhamService");
		phanLoaiService = (PhanLoaiService) Naming.lookup("rmi://" + host + ":" + port + "/phanLoaiService");
		chatLieuService = (ChatLieuService) Naming.lookup("rmi://" + host + ":" + port + "/chatLieuService");
		mauSacService = (MauSacService) Naming.lookup("rmi://" + host + ":" + port + "/mauSacService");
		xuatXuService = (XuatXuService) Naming.lookup("rmi://" + host + ":" + port + "/xuatXuService");
		nhaCungCapService = (NhaCungCapService) Naming.lookup("rmi://" + host + ":" + port + "/nhaCungCapService");

		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setSize(1345, 650);
		setLayout(null);

		JPanel pnlMaHD = new JPanel();
		pnlMaHD.setBackground(Color.LIGHT_GRAY);
		pnlMaHD.setBounds(10, 40, 230, 30);
		add(pnlMaHD);
		pnlMaHD.setLayout(null);

		JLabel lblMa = new JLabel("MÃ HOÁ ĐƠN:");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setBounds(10, 0, 92, 30);
		pnlMaHD.add(lblMa);

		lblMaHD = new JLabel("");
		lblMaHD.setBounds(116, 0, 104, 30);
		pnlMaHD.add(lblMaHD);
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaHD.setForeground(new Color(255, 0, 0));

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(Color.LIGHT_GRAY);
		pnlTitle.setBounds(0, 0, 1493, 30);
		add(pnlTitle);
		pnlTitle.setLayout(null);

		JLabel lblTitle = new JLabel("LẬP HOÁ ĐƠN");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 1337, 30);
		pnlTitle.add(lblTitle);

		tableSanPham = new JTable(modelSanPham);
		tableSanPham.setBounds(10, 307, 780, 316);
		String[] cols = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng", "Mô tả", "Màu Sắc", "Xuất Xứ",
				"Chất Liệu", "Phân Loại", "Nhà Cung Cấp" };
		modelSanPham = new DefaultTableModel(cols, 0);
		tableSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));

		scrollSach = new JScrollPane();
		scrollSach.setViewportView(tableSanPham = new JTable(modelSanPham));
		scrollSach.setBounds(10, 424, 797, 215);
		tableSanPham.getTableHeader().setBackground(Color.LIGHT_GRAY);
		tableSanPham.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableSanPham.setRowHeight(25);
		tableSanPham.setBackground(Color.WHITE);
		scrollSach.getViewport().setBackground(Color.WHITE);
		tableSanPham.getTableHeader().setPreferredSize(new Dimension(0, 20));
		add(scrollSach);
		tableSanPham.addMouseListener(this);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBounds(823, 80, 512, 559);
		add(pnlHoaDon);
		pnlHoaDon.setLayout(null);

		JLabel lblTitleHoaDon = new JLabel("HOÁ ĐƠN BÁN HÀNG");
		lblTitleHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitleHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleHoaDon.setBounds(0, 0, 622, 35);
		pnlHoaDon.add(lblTitleHoaDon);

		JLabel lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLap.setBounds(10, 45, 90, 20);
		pnlHoaDon.add(lblNgayLap);

		JLabel lblNgayThang = new JLabel("");
		lblNgayThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayThang.setForeground(new Color(255, 0, 51));
		lblNgayThang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNgayThang.setBounds(386, 46, 107, 20);
		pnlHoaDon.add(lblNgayThang);

		txtSDT = new JTextField();
		txtSDT.setBounds(120, 141, 260, 20);
		pnlHoaDon.add(txtSDT);
		txtSDT.setColumns(10);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(10, 139, 90, 20);
		pnlHoaDon.add(lblSDT);
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(120, 171, 360, 20);
		pnlHoaDon.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setBounds(10, 169, 110, 20);
		pnlHoaDon.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnTimKhachHang = new JButton("Tìm");
		btnTimKhachHang.setBounds(390, 135, 90, 30);
		pnlHoaDon.add(btnTimKhachHang);
		btnTimKhachHang.setIcon(new ImageIcon(Pn_TaoHoaDon.class.getResource("/gui/icon/loupe.png")));

		JLabel lblMaSP = new JLabel("Mã hoá đơn:");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP.setBounds(10, 75, 90, 20);
		pnlHoaDon.add(lblMaSP);

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setForeground(Color.RED);
		txtMaHoaDon.setBounds(120, 75, 360, 20);
		pnlHoaDon.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);

		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTongTien.setBounds(10, 436, 75, 20);
		pnlHoaDon.add(lblTongTien);

		txtTongTienHD = new JTextField();
		txtTongTienHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTongTienHD.setEditable(false);
		txtTongTienHD.setBounds(130, 436, 107, 20);
		pnlHoaDon.add(txtTongTienHD);
		txtTongTienHD.setColumns(10);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa:");
		lblTienKhachDua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienKhachDua.setBounds(10, 466, 110, 20);
		pnlHoaDon.add(lblTienKhachDua);

		JLabel lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhanVien.setBounds(10, 105, 90, 20);
		pnlHoaDon.add(lblNhanVien);

		txtNhanVien = new JTextField();
		txtNhanVien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtNhanVien.setEditable(false);
		txtNhanVien.setForeground(Color.RED);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(120, 105, 360, 20);

		FrmLogin dangNhap = new FrmLogin(port, host);
		TaiKhoan taiKhoan = dangNhap.getTaiKhoanDangNhapThanhCong();

		pnlHoaDon.add(txtNhanVien);

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(130, 466, 108, 20);
		pnlHoaDon.add(txtTienKhachDua);
		txtTienKhachDua.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {

				long tongTien = Long.parseLong(txtTongTienHD.getText().toString());
				long tienKhachDua = Long.parseLong(txtTienKhachDua.getText().toString().trim());
				txtTienThua.setText(String.valueOf(tienKhachDua - tongTien));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JLabel lblTienThua = new JLabel("Tiền thừa:");
		lblTienThua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienThua.setBounds(263, 466, 75, 20);
		pnlHoaDon.add(lblTienThua);

		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(343, 466, 97, 20);
		pnlHoaDon.add(txtTienThua);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBounds(208, 519, 130, 30);
		pnlHoaDon.add(btnThanhToan);

		btnXoa = new JButton("Xoá");
		btnXoa.setBounds(386, 201, 90, 30);
		pnlHoaDon.add(btnXoa);

		scrollHoaDon = new JScrollPane();
		scrollHoaDon.setBounds(13, 259, 480, 167);
		pnlHoaDon.add(scrollHoaDon);
		String[] header = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Số lượng" };
		modelHoaDon = new DefaultTableModel(header, 0);
		scrollHoaDon.setViewportView(tableHoaDon = new JTable(modelHoaDon));

		txtSoLuongTru = new JTextField();
		txtSoLuongTru.setColumns(10);
		txtSoLuongTru.setBounds(263, 204, 90, 25);
		pnlHoaDon.add(txtSoLuongTru);

		txtNgayLap = new JTextField();
		txtNgayLap.setForeground(Color.RED);
		txtNgayLap.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtNgayLap.setEditable(false);
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(120, 45, 360, 20);
		pnlHoaDon.add(txtNgayLap);

		JLabel lblXaSnPhm = new JLabel("Xóa Sản Phẩm");
		lblXaSnPhm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblXaSnPhm.setBounds(141, 205, 97, 20);
		pnlHoaDon.add(lblXaSnPhm);
		tableHoaDon.getTableHeader().setBackground(Color.LIGHT_GRAY);
		tableHoaDon.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableHoaDon.setRowHeight(25);
		tableHoaDon.setBackground(Color.WHITE);
		scrollHoaDon.getViewport().setBackground(Color.WHITE);
		tableHoaDon.getTableHeader().setPreferredSize(new Dimension(0, 20));

		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(70);
		tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(40);

		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setBounds(10, 80, 797, 231);
		add(pnlSanPham);
		pnlSanPham.setBackground(new Color(255, 255, 255));
		pnlSanPham.setLayout(null);

		JLabel lblMasp = new JLabel("Mã Sản Phẩm");
		lblMasp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMasp.setBounds(10, 10, 150, 25);
		pnlSanPham.add(lblMasp);

		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenSP.setBounds(10, 60, 150, 25);
		pnlSanPham.add(lblTenSP);

		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTen.setBounds(170, 60, 250, 25);
		pnlSanPham.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblMauSac = new JLabel("Màu Sắc");
		lblMauSac.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMauSac.setBounds(465, 10, 72, 25);
		pnlSanPham.add(lblMauSac);

		cb_MauSac = new JComboBox();
		cb_MauSac.setEnabled(false);
		cb_MauSac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_MauSac.setBounds(550, 10, 237, 25);
		pnlSanPham.add(cb_MauSac);

		JLabel lblXuatXu = new JLabel("Xuất Xứ");
		lblXuatXu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblXuatXu.setBounds(465, 60, 72, 25);
		pnlSanPham.add(lblXuatXu);

		cb_XuatXu = new JComboBox<Object>();
		cb_XuatXu.setEnabled(false);
		cb_XuatXu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_XuatXu.setBounds(550, 60, 237, 25);
		pnlSanPham.add(cb_XuatXu);

		JLabel lblGiaBan = new JLabel("Giá bán");
		lblGiaBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiaBan.setBounds(10, 150, 150, 25);
		pnlSanPham.add(lblGiaBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(170, 150, 250, 25);
		pnlSanPham.add(txtGiaBan);

		btnThemSanPham = new JButton("Thêm");

		btnThemSanPham.setBounds(692, 196, 95, 27);
		pnlSanPham.add(btnThemSanPham);

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMa.setColumns(10);
		txtMa.setBounds(170, 15, 250, 25);
		pnlSanPham.add(txtMa);

		txtSoLuongMua = new JTextField();
		txtSoLuongMua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSoLuongMua.setColumns(10);
		txtSoLuongMua.setBounds(548, 196, 106, 25);
		pnlSanPham.add(txtSoLuongMua);

		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLng.setBounds(10, 100, 150, 25);
		pnlSanPham.add(lblSLng);

		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(170, 105, 250, 25);
		pnlSanPham.add(txtSoLuong);

		JLabel lblChatLieu = new JLabel("Chất Liệu");
		lblChatLieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChatLieu.setBounds(465, 105, 72, 25);
		pnlSanPham.add(lblChatLieu);

		cb_ChatLieu = new JComboBox<Object>();
		cb_ChatLieu.setEnabled(false);
		cb_ChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_ChatLieu.setBounds(550, 105, 237, 25);
		pnlSanPham.add(cb_ChatLieu);

		JLabel lblPhanLoai = new JLabel("Phân Loại");
		lblPhanLoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhanLoai.setBounds(465, 150, 72, 25);
		pnlSanPham.add(lblPhanLoai);

		cb_PhanLoai = new JComboBox<Object>();
		cb_PhanLoai.setEnabled(false);
		cb_PhanLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_PhanLoai.setBounds(550, 150, 237, 25);
		pnlSanPham.add(cb_PhanLoai);

		JLabel lblNhaCungCap = new JLabel("Nhà Cung Cấp");
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhaCungCap.setBounds(10, 195, 106, 25);
		pnlSanPham.add(lblNhaCungCap);

		cb_NhaCungCap = new JComboBox<Object>();
		cb_NhaCungCap.setEnabled(false);
		cb_NhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_NhaCungCap.setBounds(170, 195, 250, 25);
		pnlSanPham.add(cb_NhaCungCap);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(
				new TitledBorder(null, "T\u00ECm Ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTimKiem.setBounds(10, 321, 797, 86);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		JScrollPane scrollSach_1 = new JScrollPane();
		scrollSach_1.setBounds(192, 29, 2, 2);
		pnlTimKiem.add(scrollSach_1);

		JLabel lblMaTim = new JLabel("Mã Sản Phẩm");
		lblMaTim.setBounds(62, 40, 98, 17);
		lblMaTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlTimKiem.add(lblMaTim);

		txtMaTim = new JTextField();
		txtMaTim.setBounds(170, 39, 184, 21);
		txtMaTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaTim.setColumns(10);
		pnlTimKiem.add(txtMaTim);
		txtMaTim.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					filter();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTenTim = new JLabel("Tên Sản Phẩm");
		lblTenTim.setBounds(384, 40, 104, 17);
		lblTenTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlTimKiem.add(lblTenTim);

		txtTenTim = new JTextField();
		txtTenTim.setBounds(498, 39, 217, 21);
		txtTenTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenTim.setColumns(10);
		pnlTimKiem.add(txtTenTim);
		txtTenTim.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					filter();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		loadTableSanPham();
		loadComboBoxThuocTinh();
		setDefault();

		tableHoaDon.addMouseListener(this);
		btnXoa.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemSanPham.addActionListener(this);
		btnTimKhachHang.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(tableSanPham)) {
			int row = tableSanPham.getSelectedRow();
			tableHoaDon.clearSelection();
			modelSanPham = (DefaultTableModel) tableSanPham.getModel();
			txtMa.setText(modelSanPham.getValueAt(row, 0).toString());
			txtTen.setText(modelSanPham.getValueAt(row, 1).toString());
			txtSoLuong.setText(modelSanPham.getValueAt(row, 3).toString());
			txtGiaBan.setText(modelSanPham.getValueAt(row, 2).toString());

			cb_MauSac.setSelectedItem(modelSanPham.getValueAt(row, 5).toString());
			cb_XuatXu.setSelectedItem(modelSanPham.getValueAt(row, 6).toString());
			cb_ChatLieu.setSelectedItem(modelSanPham.getValueAt(row, 7).toString());
			cb_PhanLoai.setSelectedItem(modelSanPham.getValueAt(row, 8).toString());
			cb_NhaCungCap.setSelectedItem(modelSanPham.getValueAt(row, 9).toString());

		} else if (object.equals(tableHoaDon)) {
			tableSanPham.clearSelection();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThemSanPham)) {
			int row = tableSanPham.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm");
				return;
			}

			int soLuong = Integer.parseInt(txtSoLuongMua.getText().toString());
			modelSanPham = (DefaultTableModel) tableSanPham.getModel();
			if (soLuong > Integer.parseInt(modelSanPham.getValueAt(row, 3).toString())) {
				JOptionPane.showMessageDialog(this, "Số lượng tồn kho không đủ");
				txtSoLuongMua.requestFocus();
				return;
			}
			SanPham sanPham = null;
			try {
				sanPham = sanPhamService.findSanPhamById(modelSanPham.getValueAt(row, 0).toString());
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			modelHoaDon = (DefaultTableModel) tableHoaDon.getModel();
			for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
				if (sanPham.getMaSP().equalsIgnoreCase(modelHoaDon.getValueAt(i, 1).toString())) {
					modelHoaDon.setValueAt(Integer.parseInt(modelHoaDon.getValueAt(i, 4).toString()) + soLuong, i, 4);
					int soLuongBD = sanPham.getSoLuong();
					modelSanPham.setValueAt(Integer.parseInt(modelSanPham.getValueAt(row, 3).toString()) - soLuong, row,
							3);
					sanPham.setSoLuong(soLuongBD - soLuong);
					try {
						sanPhamService.updateSanPham(sanPham);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtSoLuongMua.setText("");
					tableSanPham.clearSelection();

					// tinh tong tien
					txtTongTienHD.setText(tinhTongTien() + "");
					return;
				}
			}
			int soLuongBD = sanPham.getSoLuong();
			modelSanPham.setValueAt(Integer.parseInt(modelSanPham.getValueAt(row, 3).toString()) - soLuong, row, 3);
			sanPham.setSoLuong(soLuongBD - soLuong);
			Object[] rowData = { modelHoaDon.getRowCount() + 1, sanPham.getMaSP(), sanPham.getTenSP(),
					sanPham.tinhGiaBan(), soLuong };
			modelHoaDon.addRow(rowData);
			try {
				sanPhamService.updateSanPham(sanPham);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtSoLuongMua.setText("");
			tableSanPham.clearSelection();
			// tinh tong tien
			txtTongTienHD.setText(tinhTongTien() + "");
		} else if (obj.equals(btnTimKhachHang)) {
			String sdt = txtSDT.getText().toString();
			try {
				if (khachHangService.getKhachHangBySDT(sdt).size() == 0) {
					result = JOptionPane.showConfirmDialog(this,
							"Không tìm thấy khách hàng. Bạn có muốn thêm khách hàng không?", "Xác nhận",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						try {

							new Pn_ThemKhachHang(port, host, sdt).setVisible(true);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					else if (result == JOptionPane.NO_OPTION) {
						txtSDT.requestFocus();
					}
				} else {
					txtTenKhachHang.setText(khachHangService.getKhachHangBySDT(sdt).get(0).getHoVaTen());
					khachHang = khachHangService.getKhachHangBySDT(sdt).get(0);
				}

			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj.equals(btnXoa)) {
			int row = tableHoaDon.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu");
				return;
			}
			int soLuongTru = Integer.parseInt(txtSoLuongTru.getText().toString().trim());
			if (soLuongTru > Integer.parseInt(modelHoaDon.getValueAt(row, 4).toString())) {
				JOptionPane.showMessageDialog(this, "Số lượng trong giỏ hàng không đủ");
				txtSoLuongMua.requestFocus();
				return;
			}
			modelHoaDon = (DefaultTableModel) tableHoaDon.getModel();
			modelSanPham = (DefaultTableModel) tableSanPham.getModel();
			if ((Integer.parseInt(modelHoaDon.getValueAt(row, 4).toString()) - soLuongTru) > 0) {
				modelHoaDon.setValueAt(Integer.parseInt(modelHoaDon.getValueAt(row, 4).toString()) - soLuongTru, row,
						4);
				SanPham sanPham = null;
				try {
					sanPham = sanPhamService.findSanPhamById(modelHoaDon.getValueAt(row, 1).toString());
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println(sanPham);
				for (int i = 0; i < modelSanPham.getRowCount(); i++) {
					if (sanPham.getMaSP().equalsIgnoreCase(modelSanPham.getValueAt(i, 0).toString())) {
						System.err.println("a");
						int soLuongBD = sanPham.getSoLuong();
						modelSanPham.setValueAt(Integer.parseInt(modelSanPham.getValueAt(i, 3).toString()) + soLuongTru,
								i, 3);
						sanPham.setSoLuong(soLuongBD + soLuongTru);
						try {
							sanPhamService.updateSanPham(sanPham);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						txtSoLuongTru.setText("");
						tableHoaDon.clearSelection();
						// tinh Tong tien
						txtTongTienHD.setText(tinhTongTien() + "");

						return;
					}
				}
			} else {
				modelHoaDon.removeRow(row);
				txtSoLuongTru.setText("");

			}

		} else if (obj.equals(btnThanhToan)) {
			if (Long.parseLong(txtTienThua.getText()) > 0) {
				modelHoaDon = (DefaultTableModel) tableHoaDon.getModel();
				HoaDon hoaDon = null;
				try {
					hoaDon = new HoaDon(lblMaHD.getText().toString(), khachHang,
							new FrmLogin(port, host).getTaiKhoanDangNhapThanhCong().getNhanVien(),
							new Date(System.currentTimeMillis()));
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NotBoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					hoaDonService.addHoaDon(hoaDon);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
					SanPham sanPham;
					try {
						sanPham = sanPhamService.findSanPhamById(modelHoaDon.getValueAt(i, 1).toString());
						int soLuong = Integer.parseInt(modelHoaDon.getValueAt(i, 4).toString());
						long giaBan = Long.parseLong(modelHoaDon.getValueAt(i, 3).toString());
						ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sanPham, hoaDon, soLuong, soLuong * giaBan);
						System.out.println(chiTietHoaDon);
						chiTietHoaDonService.addChiTietHoaDon(chiTietHoaDon);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				JOptionPane.showMessageDialog(this, "Thanh toán thành công");

				// Xuat hoa don
				System.out.println(txtMaHoaDon.getText());
				xuatHoaDon(txtMaHoaDon.getText());

				txtTongTienHD.setText("");
				txtTienKhachDua.setText("");
				txtTienThua.setText("");
				modelHoaDon.setRowCount(0);
				txtSDT.setText("");
				txtTenKhachHang.setText("");
				try {
					setDefault();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else {
				JOptionPane.showMessageDialog(this, "Tiền khách đưa chưa đủ");
			}
		}

	}

	public long tinhTongTien() {
		modelHoaDon = (DefaultTableModel) tableHoaDon.getModel();
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			long giaBan = Long.parseLong(modelHoaDon.getValueAt(i, 3).toString());
			int soLuong = Integer.parseInt(modelHoaDon.getValueAt(i, 4).toString());
			total = total + (soLuong * giaBan);
		}

		return total;

	}

	public void loadTableSanPham() throws RemoteException {
		List<SanPham> list = sanPhamService.getAllSanPham();
		modelSanPham = (DefaultTableModel) tableSanPham.getModel();
		for (SanPham sanPham : list) {
			Object[] rowData = { sanPham.getMaSP(), sanPham.getTenSP(), sanPham.tinhGiaBan(), sanPham.getSoLuong(),
					sanPham.getMoTa(), sanPham.getMauSac().getMauSac(), sanPham.getXuatXu().getNoiXuatXu(),
					sanPham.getChatLieu().getChatLieu(), sanPham.getPhanLoai().getLoaiSanPham(),
					sanPham.getNhaCungCap().getTenNCC() };
			modelSanPham.addRow(rowData);
		}
	}

	public void loadComboBoxThuocTinh() throws RemoteException {
		mauSacService.getAllMauSac().forEach(mauSac -> cb_MauSac.addItem(mauSac.getMauSac()));

		xuatXuService.getAllXuatXu().forEach(xuatXu -> cb_XuatXu.addItem(xuatXu.getNoiXuatXu()));

		chatLieuService.getAllChatLieu().forEach(chatLieu -> cb_ChatLieu.addItem(chatLieu.getChatLieu()));

		phanLoaiService.getAllPhanLoai().forEach(phanLoai -> cb_PhanLoai.addItem(phanLoai.getLoaiSanPham()));

		nhaCungCapService.getAllNhaCungCap().forEach(nhaCungCap -> cb_NhaCungCap.addItem(nhaCungCap.getTenNCC()));
	}

	public void clearTable() {
		modelSanPham = (DefaultTableModel) tableSanPham.getModel();
		modelSanPham.setRowCount(0);
	}

	public void filter() throws RemoteException {
		clearTable();
		String ma = txtMaTim.getText().toString().trim();
		String ten = txtTenTim.getText().toString().trim();
		List<SanPham> list = sanPhamService.getAllSanPham();
		modelSanPham = (DefaultTableModel) tableSanPham.getModel();

		for (SanPham sanPham : list) {
			if (sanPham.getMaSP().toLowerCase().contains(ma.toLowerCase())
					&& sanPham.getTenSP().toLowerCase().contains(ten.toLowerCase())) {
				Object[] rowData = { sanPham.getMaSP(), sanPham.getTenSP(), sanPham.tinhGiaBan(), sanPham.getSoLuong(),
						sanPham.getMoTa(), sanPham.getMauSac().getMauSac(), sanPham.getXuatXu().getNoiXuatXu(),
						sanPham.getChatLieu().getChatLieu(), sanPham.getPhanLoai().getLoaiSanPham(),
						sanPham.getNhaCungCap().getTenNCC() };
				modelSanPham.addRow(rowData);
			}

		}
	}

	public void setDefault() throws MalformedURLException, RemoteException, NotBoundException {
		String idPrefix = "HD";
		int length;
//		try {
//			length = hoaDonService.getAllHoaDon().size();
//			String finalId = idPrefix + String.format("%04d", length + 1);
//			lblMaHD.setText(finalId);
//		} catch (RemoteException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}

		txtMaHoaDon.setText(lblMaHD.getText().toString());
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String ngay = sdf.format(date);
		txtNgayLap.setText(ngay);
		txtNhanVien.setText(new FrmLogin(port, host).getTaiKhoanDangNhapThanhCong().getNhanVien().getHoVaTen());
	}

	public void xuatHoaDon(String maHD) {
		try {
			Hashtable map = new Hashtable();
			File file = new File("");
			String path = file.getAbsolutePath();
			JasperReport report = JasperCompileManager.compileReport(path + "//src//main//java//gui//Blank3_A4.jrxml");
			map.put("maHD", maHD);
			JasperPrint p = JasperFillManager.fillReport(report, map, DBConnection());

			JasperViewer.viewReport(p, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection DBConnection() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBHSPORT;trustServerCertificate=true";

		String user = "sa";
		String pass = "sapassword";
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
