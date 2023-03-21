package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.hibernate.internal.util.StringHelper;

import bus.ChatLieuService;
import bus.MauSacService;
import bus.NhaCungCapService;
import bus.PhanLoaiService;
import bus.SanPhamService;
import bus.XuatXuService;
import entity.ChatLieu;
import entity.MauSac;
import entity.NhaCungCap;
import entity.PhanLoai;
import entity.SanPham;
import entity.XuatXu;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Pn_QuanLySanPham extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelSanPham;
	private JTable tableSanPham;
	private JScrollPane scrollSanPham;
	private JButton btnThemSP;
	private JButton btnCapNhat;
	private JButton btnLuu;
	private JPanel panel_1;
	private JLabel lblImageSP;
	private JLabel lblTenSP;
	private JLabel lblSoLuong;
	private JLabel lblGiaBan;
	private JLabel lblMoTa;
	private JTextField txtMaSP_Tim;
	private JTextField txtTenSP_Tim;
	private ImageIcon imageIcon;
	private int mauTinHienHanh;
	private int tongSoMauTin;
	private JButton btnQuanLyThuocTinh;
	private JFileChooser filechoose;
	private File file;

	private SanPhamService sanPhamService;
	private PhanLoaiService phanLoaiService;
	private ChatLieuService chatLieuService;
	private MauSacService mauSacService;
	private XuatXuService xuatXuService;
	private NhaCungCapService nhaCungCapService;

	private JLabel lblHinhAnh;
	private JLabel lblMuSc;
	private JLabel lblXutX;
	private JLabel lblChtLiu;
	private JLabel lblPhnLoi;
	private JLabel lblNhCungCp;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSoLuong;
	private JTextField txtGiaBan;
	private JTextField txtMoTa;
	private JLabel lblMaSP_1;
	private JLabel lblTenSP_1;

	private JComboBox cb_MauSac;
	private JComboBox cb_XuatXu;
	private JComboBox cb_ChatLieu;
	private JComboBox cb_PhanLoai;
	private JComboBox cb_NhaCungCap;
	private JLabel lblGiaNhap;
	private JTextField txtGiaNhap;
	private JButton btnChonAnh;
	private JPanel pnl_HinhAnh;
	private int port;
	private String host;

	public Pn_QuanLySanPham(int port, String host) throws Exception {
		this.host = host;
		this.port = port;

		sanPhamService = (SanPhamService) Naming.lookup("rmi://"+host+":" + port + "/sanPhamService");
		phanLoaiService = (PhanLoaiService) Naming.lookup("rmi://"+host+":" + port + "/phanLoaiService");
		chatLieuService = (ChatLieuService) Naming.lookup("rmi://"+host+":" + port + "/chatLieuService");
		mauSacService = (MauSacService) Naming.lookup("rmi://"+host+":" + port + "/mauSacService");
		xuatXuService = (XuatXuService) Naming.lookup("rmi://"+host+":" + port + "/xuatXuService");
		nhaCungCapService = (NhaCungCapService) Naming.lookup("rmi://"+host+":" + port + "/nhaCungCapService");

		setSize(1345, 650);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(10, 0, 1325, 44);
		add(lblTitle);

		JPanel pnLoc = new JPanel();
		pnLoc.setBackground(new Color(255, 255, 255));
		pnLoc.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pnLoc.setBounds(10, 313, 260, 301);
		add(pnLoc);
		pnLoc.setLayout(null);
		txtMaSP_Tim = new JTextField();
		txtMaSP_Tim.setForeground(Color.GRAY);
		txtMaSP_Tim.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaSP_Tim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaSP_Tim.setBounds(10, 66, 240, 37);
		pnLoc.add(txtMaSP_Tim);
		txtMaSP_Tim.setColumns(10);
		txtMaSP_Tim.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					filter();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtTenSP_Tim = new JTextField();
		txtTenSP_Tim.setForeground(Color.GRAY);
		txtTenSP_Tim.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenSP_Tim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenSP_Tim.setColumns(10);
		txtTenSP_Tim.setBounds(10, 183, 240, 37);
		pnLoc.add(txtTenSP_Tim);
		txtTenSP_Tim.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					filter();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		lblMaSP_1 = new JLabel("Mã sản phẩm: ");
		lblMaSP_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSP_1.setBounds(75, 24, 131, 19);
		pnLoc.add(lblMaSP_1);

		lblTenSP_1 = new JLabel("Tên sản phẩm: ");
		lblTenSP_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSP_1.setBounds(75, 132, 131, 19);
		pnLoc.add(lblTenSP_1);

		imageIcon = setSizeImageIconURL(Pn_QuanLySanPham.class.getResource("/gui/icon/loupe.png"), 13, 13);

		ButtonGroup G = new ButtonGroup();

		String[] cols = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng", "Mô tả", "Màu Sắc", "Xuất Xứ",
				"Chất Liệu", "Phân Loại", "Nhà Cung Cấp" };
		modelSanPham = new DefaultTableModel(cols, 0);
		tableSanPham = new JTable(modelSanPham);
		tableSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));

		scrollSanPham = new JScrollPane(tableSanPham);
		scrollSanPham.setBounds(280, 262, 1055, 351);

		tableSanPham.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSanPham.setAutoCreateRowSorter(true);
		tableSanPham.setRowHeight(25);
		tableSanPham.setBackground(Color.WHITE);
		scrollSanPham.getViewport().setBackground(Color.WHITE);
		tableSanPham.getTableHeader().setPreferredSize(new Dimension(0, 40));
		add(scrollSanPham);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.LIGHT_GRAY);
		pnTimKiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnTimKiem.setBounds(10, 262, 260, 50);
		add(pnTimKiem);
		pnTimKiem.setLayout(null);
		JLabel lblTimKiem = new JLabel("Bộ lọc");
		lblTimKiem.setBounds(51, 0, 146, 50);
		pnTimKiem.add(lblTimKiem);
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTimKiem.setForeground(new Color(255, 255, 255));
		lblTimKiem.setBackground(new Color(58, 176, 242));

		btnThemSP = new JButton("Thêm");
		btnThemSP.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemSP.setIcon(setSizeImageIconURL(Pn_QuanLySanPham.class.getResource("/gui/icon/add.png"), 16, 16));
		btnThemSP.setBounds(1014, 173, 130, 40);
		add(btnThemSP);
		btnThemSP.setBackground(Color.LIGHT_GRAY);
		btnThemSP.setForeground(new Color(0, 0, 0));
		btnThemSP.setFont(new Font("Dialog", Font.BOLD, 16));

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat
				.setIcon(setSizeImageIconURL(Pn_QuanLySanPham.class.getResource("/gui/icon/maintenance.png"), 25, 25));
		btnCapNhat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCapNhat.setBounds(1175, 173, 139, 40);
		add(btnCapNhat);
		btnCapNhat.setForeground(new Color(0, 0, 0));
		btnCapNhat.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCapNhat.setBackground(Color.LIGHT_GRAY);

		btnQuanLyThuocTinh = new JButton("Quản lý thuộc tính");
		btnQuanLyThuocTinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyThuocTinh.setBounds(1014, 118, 176, 40);
		add(btnQuanLyThuocTinh);
		btnQuanLyThuocTinh.setFont(new Font("Dialog", Font.BOLD, 16));

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(290, 54, 714, 198);
		add(panel_1);
		panel_1.setLayout(null);

		lblTenSP = new JLabel("Tên sản phẩm: ");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSP.setBounds(10, 47, 131, 19);
		panel_1.add(lblTenSP);

		lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(45, 76, 96, 21);
		panel_1.add(lblSoLuong);

		lblGiaBan = new JLabel("Giá bán: ");
		lblGiaBan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiaBan.setBounds(55, 167, 70, 19);
		panel_1.add(lblGiaBan);

		lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMoTa.setBounds(71, 109, 58, 19);
		panel_1.add(lblMoTa);

		JLabel lblMaSP = new JLabel("Mã sản phẩm: ");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSP.setBounds(10, 18, 131, 19);
		panel_1.add(lblMaSP);

		lblMuSc = new JLabel("Màu Sắc:");
		lblMuSc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMuSc.setBounds(407, 18, 70, 19);
		panel_1.add(lblMuSc);

		lblXutX = new JLabel("Xuất Xứ:");
		lblXutX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXutX.setBounds(409, 47, 68, 19);
		panel_1.add(lblXutX);

		lblChtLiu = new JLabel("Chất Liệu:");
		lblChtLiu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChtLiu.setBounds(399, 76, 84, 21);
		panel_1.add(lblChtLiu);

		lblPhnLoi = new JLabel("Phân Loại:");
		lblPhnLoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhnLoi.setBounds(399, 109, 96, 19);
		panel_1.add(lblPhnLoi);

		lblNhCungCp = new JLabel("Nhà Cung Cấp:");
		lblNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhCungCp.setBounds(363, 138, 114, 19);
		panel_1.add(lblNhCungCp);

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(135, 18, 195, 19);
		panel_1.add(txtMa);
		txtMa.setColumns(10);

		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setColumns(10);
		txtTen.setBounds(135, 49, 195, 19);
		panel_1.add(txtTen);

		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(135, 79, 195, 19);
		panel_1.add(txtSoLuong);

		txtGiaBan = new JTextField();
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(135, 169, 195, 19);
		panel_1.add(txtGiaBan);

		txtMoTa = new JTextField();
		txtMoTa.setEditable(false);
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(135, 111, 195, 19);
		panel_1.add(txtMoTa);

		cb_MauSac = new JComboBox();
		cb_MauSac.setBounds(497, 19, 180, 21);
		panel_1.add(cb_MauSac);

		cb_XuatXu = new JComboBox();
		cb_XuatXu.setBounds(497, 48, 180, 21);
		panel_1.add(cb_XuatXu);

		cb_ChatLieu = new JComboBox();
		cb_ChatLieu.setBounds(497, 78, 180, 21);
		panel_1.add(cb_ChatLieu);

		cb_PhanLoai = new JComboBox();
		cb_PhanLoai.setBounds(497, 110, 180, 21);
		panel_1.add(cb_PhanLoai);

		cb_NhaCungCap = new JComboBox();
		cb_NhaCungCap.setBounds(497, 139, 180, 21);
		panel_1.add(cb_NhaCungCap);

		lblGiaNhap = new JLabel("Giá Nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiaNhap.setBounds(45, 138, 84, 19);
		panel_1.add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setEditable(false);
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(135, 140, 195, 19);
		panel_1.add(txtGiaNhap);
		txtGiaNhap.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				txtGiaBan.setText(String.valueOf((long) (Long.parseLong(txtGiaNhap.getText().toString()) * 1.1)));
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnQuanLyThuocTinh.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnCapNhat.addActionListener(this);
		tableSanPham.addMouseListener(this);

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setHorizontalAlignment(SwingConstants.LEFT);
		btnLuu.setForeground(Color.BLACK);
		btnLuu.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLuu.setBackground(Color.LIGHT_GRAY);
		btnLuu.setBounds(1217, 118, 97, 40);
		add(btnLuu);

		pnl_HinhAnh = new JPanel();
		pnl_HinhAnh.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl_HinhAnh.setBounds(10, 54, 159, 159);
		add(pnl_HinhAnh);
		pnl_HinhAnh.setLayout(null);

		lblHinhAnh = new JLabel("Hình Ảnh");
		lblHinhAnh.setBounds(0, 0, 159, 159);
		pnl_HinhAnh.add(lblHinhAnh);
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);

		loadTableSanPham();
		loadComboBoxThuocTinh();

		btnLuu.addActionListener(this);

		btnChonAnh = new JButton("Chọn File");
		btnChonAnh.setEnabled(false);
		btnChonAnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChonAnh.setBounds(173, 221, 97, 31);
		add(btnChonAnh);
		btnChonAnh.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuanLyThuocTinh))
			try {
				new Frm_QuanLyThuocTinh(port,host).setVisible(true);
			} catch (MalformedURLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (RemoteException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (NotBoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		else if (o.equals(btnThemSP) && btnThemSP.getText().equalsIgnoreCase("Thêm")) {
			xoaTrang();
			String idPrefix = "SP";
			int length;
			try {
				length = sanPhamService.getAllSanPham().size();
				String finalId = idPrefix + String.format("%04d", length + 1);
				txtMa.setText(finalId);
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			btnThemSP.setText("Hủy");
			btnLuu.setEnabled(true);
			btnCapNhat.setEnabled(false);
			moKhoaTextField(true);
		} else if (o.equals(btnThemSP) && btnThemSP.getText().equalsIgnoreCase("Hủy")) {
			moKhoaTextField(false);
			btnLuu.setEnabled(false);
			btnCapNhat.setEnabled(true);
			btnThemSP.setText("Thêm");
			xoaTrang();
		} else if (o.equals(btnLuu) && btnThemSP.getText().equalsIgnoreCase("Hủy")) {
			SanPham sanPham = null;
			try {
				sanPham = loadDataFromTextField();
				modelSanPham = (DefaultTableModel) tableSanPham.getModel();
				for (int i = 0; i< modelSanPham.getRowCount(); i++) {
					if(sanPham.getTenSP().toLowerCase().equalsIgnoreCase(modelSanPham.getValueAt(i, 1).toString().toLowerCase())) {
						SanPham sp = sanPhamService.findSanPhamById(modelSanPham.getValueAt(i, 0).toString());
						int soLuongBD = sp.getSoLuong();
						int soLuongThem = sanPham.getSoLuong();
						sanPham.setSoLuong(soLuongBD+soLuongThem);
						sanPhamService.updateSanPham(sanPham);
						modelSanPham.setValueAt(sanPham.getSoLuong(),i, 3);
						JOptionPane.showMessageDialog(this, "Sản phẩm trùng. Cập nhật số lượng");
						return;
					}
				}
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				sanPhamService.addSanPham(sanPham);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
			Object[] rowData = { sanPham.getMaSP(), sanPham.getTenSP(), sanPham.tinhGiaBan(), sanPham.getSoLuong(),
					sanPham.getMoTa(), sanPham.getMauSac().getMauSac(), sanPham.getXuatXu().getNoiXuatXu(),
					sanPham.getChatLieu().getChatLieu(), sanPham.getPhanLoai().getLoaiSanPham(),
					sanPham.getNhaCungCap().getTenNCC() };
			modelSanPham.addRow(rowData);
			xoaTrang();
			moKhoaTextField(false);

			btnLuu.setEnabled(false);

			btnThemSP.setText("Thêm");
			
		} else if (o.equals(btnLuu) && btnCapNhat.getText().equalsIgnoreCase("Hủy")) {
			SanPham sanPham = null;
			try {
				sanPham = loadDataFromTextField();
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				sanPhamService.updateSanPham(sanPham);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công");
			editOnRow(sanPham);
			xoaTrang();
			moKhoaTextField(false);

			btnLuu.setEnabled(false);

			btnCapNhat.setText("Cập nhật");
		} else if (o.equals(btnCapNhat) && btnCapNhat.getText().equalsIgnoreCase("Cập nhật")) {
			int row = tableSanPham.getSelectedRow();
			if (row == -1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu muốn sửa");
			else {
				btnCapNhat.setText("Hủy");
				btnLuu.setEnabled(true);
				btnThemSP.setEnabled(false);
				moKhoaTextField(true);
			}
		} else if (o.equals(btnCapNhat) && btnCapNhat.getText().equalsIgnoreCase("Hủy")) {
			moKhoaTextField(false);
			btnLuu.setEnabled(false);
			btnThemSP.setEnabled(true);
			btnCapNhat.setText("Cập nhật");
			tableSanPham.clearSelection();
			xoaTrang();
		} else if (o.equals(btnChonAnh)) {
			File file = new File("");
			String path = file.getAbsolutePath();
			JFileChooser filechoose = new JFileChooser(path + "\\hinhAnh");
			FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("hinh anh", "jpg", "png");
			filechoose.setFileFilter(imageFilter);
			filechoose.setMultiSelectionEnabled(false);

			int x = filechoose.showDialog(this, "Chọn Ảnh");
			if (x == JFileChooser.APPROVE_OPTION) {
				file = filechoose.getSelectedFile();
				lblHinhAnh.setText("");
				lblHinhAnh.setIcon(ResizeImage(file.getAbsolutePath()));
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(tableSanPham)) {
			int row = tableSanPham.getSelectedRow();
			modelSanPham = (DefaultTableModel) tableSanPham.getModel();
			txtMa.setText(modelSanPham.getValueAt(row, 0).toString());
			txtTen.setText(modelSanPham.getValueAt(row, 1).toString());
			txtSoLuong.setText(modelSanPham.getValueAt(row, 3).toString());
			txtGiaBan.setText(modelSanPham.getValueAt(row, 2).toString());
			txtMoTa.setText(modelSanPham.getValueAt(row, 4).toString());
			SanPham sanPham = null;
			try {
				sanPham = sanPhamService.findSanPhamById(modelSanPham.getValueAt(row, 0).toString());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			txtGiaNhap.setText(String.valueOf(sanPham.getGiaNhap()));

			cb_MauSac.setSelectedItem(modelSanPham.getValueAt(row, 5).toString());
			cb_XuatXu.setSelectedItem(modelSanPham.getValueAt(row, 6).toString());
			cb_ChatLieu.setSelectedItem(modelSanPham.getValueAt(row, 7).toString());
			cb_PhanLoai.setSelectedItem(modelSanPham.getValueAt(row, 8).toString());
			cb_NhaCungCap.setSelectedItem(modelSanPham.getValueAt(row, 9).toString());

			File file = new File("");
			String path = file.getAbsolutePath();
			lblHinhAnh.setText("");
			lblHinhAnh.setIcon(ResizeImage(path + "\\hinhAnh\\" + sanPham.getHinhAnh()));

		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public ImageIcon setSizeImageIconURL(URL url, int width, int height) {
		ImageIcon image = new ImageIcon(url);
		Image imageSet = image.getImage();
		imageSet = imageSet.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		image = new ImageIcon(imageSet);
		return image;
	}

	public ImageIcon setSizeImageIconString(String s, int width, int height) {
		ImageIcon image = new ImageIcon(s);
		Image imageSet = image.getImage();
		imageSet = imageSet.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		image = new ImageIcon(imageSet);
		return image;
	}

	public void loadTableSanPham() throws RemoteException {
		List<SanPham> list = sanPhamService.getAllSanPham();
		modelSanPham = (DefaultTableModel) tableSanPham.getModel();
		for (SanPham sanPham : list) {
			Object[] rowData = { sanPham.getMaSP(), sanPham.getTenSP(), sanPham.tinhGiaBan(), sanPham.getSoLuong(),
					sanPham.getMoTa(), sanPham.getMauSac().getMauSac(), sanPham.getXuatXu().getNoiXuatXu(),
					sanPham.getChatLieu().getChatLieu(), sanPham.getPhanLoai().getLoaiSanPham(),
					sanPham.getNhaCungCap().getTenNCC()};
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

	public void filter() throws RemoteException {
		clearTable();
		String ma = txtMaSP_Tim.getText().toString().trim();
		String ten = txtTenSP_Tim.getText().toString().trim();

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

	public void clearTable() {
		modelSanPham = (DefaultTableModel) tableSanPham.getModel();
		modelSanPham.setRowCount(0);
	}

	public void xoaTrang() {
		txtMa.setText("");
		txtTen.setText("");
		txtSoLuong.setText("");
		txtGiaBan.setText("");
		txtMoTa.setText("");
		txtGiaNhap.setText("");
		lblHinhAnh.setText("");
		cb_MauSac.setSelectedIndex(0);
		cb_XuatXu.setSelectedIndex(0);
		cb_ChatLieu.setSelectedIndex(0);
		cb_PhanLoai.setSelectedIndex(0);
		cb_NhaCungCap.setSelectedIndex(0);
	}

	public void moKhoaTextField(boolean isActive) {
		txtTen.setEditable(isActive);
		txtSoLuong.setEditable(isActive);
		txtGiaBan.setEditable(isActive);
		txtMoTa.setEditable(isActive);
		txtGiaNhap.setEditable(isActive);

		btnChonAnh.setEnabled(isActive);

		cb_MauSac.setEditable(isActive);
		cb_XuatXu.setEditable(isActive);
		cb_ChatLieu.setEditable(isActive);
		cb_PhanLoai.setEditable(isActive);
		cb_NhaCungCap.setEditable(isActive);
	}

	public SanPham loadDataFromTextField() throws RemoteException {
		String ma = txtMa.getText().toString().trim();
		String ten = txtTen.getText().toString().trim();
		int soLuong = Integer.parseInt(txtSoLuong.getText().toString().trim());
		String moTa = txtMoTa.getText().toString().trim();
		long giaNhap = Long.parseLong(txtGiaNhap.getText().toString().trim());

		String mauSac = cb_MauSac.getSelectedItem().toString();
		MauSac ms = mauSacService.getMauSacByName(mauSac);

		String noiXuatXu = cb_XuatXu.getSelectedItem().toString();
		XuatXu xuatXu = xuatXuService.getXuatXuByName(noiXuatXu);

		String chatLieu = cb_ChatLieu.getSelectedItem().toString();
		ChatLieu cl = chatLieuService.findChatLieuByName(chatLieu);

		String loaiSP = cb_PhanLoai.getSelectedItem().toString();
		PhanLoai pl = phanLoaiService.getPhanLoaiByName(loaiSP);

		String tenNhaCungCap = cb_NhaCungCap.getSelectedItem().toString();
		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapByName(tenNhaCungCap);

		String hinhAnh = "";

		SanPham sanPham = new SanPham(ma, ten, giaNhap, hinhAnh, soLuong, moTa, cl, ms, xuatXu, nhaCungCap,
				pl);

		return sanPham;
	}

	public void editOnRow(SanPham sanPham) {
		int row = tableSanPham.getSelectedRow();
		modelSanPham = (DefaultTableModel) tableSanPham.getModel();

		modelSanPham.setValueAt(sanPham.getMaSP(), row, 0);
		modelSanPham.setValueAt(sanPham.getTenSP(), row, 1);
		modelSanPham.setValueAt(sanPham.tinhGiaBan(), row, 2);
		modelSanPham.setValueAt(sanPham.getSoLuong(), row, 3);
		modelSanPham.setValueAt(sanPham.getMoTa(), row, 4);
		modelSanPham.setValueAt(sanPham.getMauSac().getMauSac(), row, 5);
		modelSanPham.setValueAt(sanPham.getXuatXu().getNoiXuatXu(), row, 6);
		modelSanPham.setValueAt(sanPham.getChatLieu().getChatLieu(), row, 7);
		modelSanPham.setValueAt(sanPham.getPhanLoai().getLoaiSanPham(), row, 8);
		modelSanPham.setValueAt(sanPham.getNhaCungCap().getTenNCC(), row, 9);

	}

	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon myImage = new ImageIcon(imgPath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(pnl_HinhAnh.getWidth(), pnl_HinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}
}
