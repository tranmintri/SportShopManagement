package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Row;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

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
import entity.SanPham;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Pn_QuanLyHoaDon extends JPanel implements ActionListener, MouseListener {

	private DefaultTableModel tableModel_HoaDon;
	private JTable table_HoaDon;
	private JScrollPane sp_tableHoaDon;
	private DefaultTableModel tableModel_SanPham;
	private JTable tableSanPham;
	private JScrollPane sp_tableSanPham;
	private JTextField txtNgayLap;
	private JTextField txtTenNV;
	private JTextField txtTenKH;
	private JTextField txtTongTien;
	private JTextField txtTenKH_Tim;
	private JTextField txtTenNV_Tim;
	private JButton btnXuatHoaDon;
	private int port;
	private String host;
	private SanPhamService sanPhamService;
	private ChiTietHoaDonService chiTietHoaDonService;
	private HoaDonService hoaDonService;
	private KhachHangService khachHangService;
	private JTextField txtMaHD;

	/**
	 * Create the panel.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Pn_QuanLyHoaDon(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {
		this.port = port;
		this.host = host;

		khachHangService = (KhachHangService) Naming.lookup("rmi://" + host + ":" + port + "/khachHangService");
		chiTietHoaDonService = (ChiTietHoaDonService) Naming
				.lookup("rmi://" + host + ":" + port + "/chiTietHoaDonService");
		hoaDonService = (HoaDonService) Naming.lookup("rmi://" + host + ":" + port + "/hoaDonService");
		sanPhamService = (SanPhamService) Naming.lookup("rmi://" + host + ":" + port + "/sanPhamService");

		setSize(1345, 650);
		setLayout(null);

		String header_HoaDon[] = { "STT", "Mã hóa đơn", "Tên nhân viên", "Tên Khách Hàng", "Ngày lập" };
		tableModel_HoaDon = new DefaultTableModel(header_HoaDon, 0);
		table_HoaDon = new JTable(tableModel_HoaDon);
		sp_tableHoaDon = new JScrollPane(table_HoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp_tableHoaDon.setBounds(10, 120, 1325, 197);
		table_HoaDon.setAutoCreateRowSorter(true);
		add(sp_tableHoaDon);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "T\u00ECm Ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 1325, 100);
		add(panel);
		panel.setLayout(null);

		txtTenKH_Tim = new JTextField();
		txtTenKH_Tim.setColumns(10);
		txtTenKH_Tim.setBounds(315, 37, 305, 26);
		panel.add(txtTenKH_Tim);
		txtTenKH_Tim.addKeyListener(new KeyListener() {

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

		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenKH.setBounds(135, 43, 156, 20);
		panel.add(lblTenKH);

		txtTenNV_Tim = new JTextField();
		txtTenNV_Tim.setColumns(10);
		txtTenNV_Tim.setBounds(912, 37, 324, 26);
		panel.add(txtTenNV_Tim);
		txtTenNV_Tim.addKeyListener(new KeyListener() {

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

		JLabel lblTenNv_Tim = new JLabel("Tên Nhân Viên");
		lblTenNv_Tim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNv_Tim.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenNv_Tim.setBounds(720, 37, 156, 20);
		panel.add(lblTenNv_Tim);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m \u0111\u00E3 mua",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 375, 838, 265);
		add(panel_1);
		panel_1.setLayout(null);

		String header_SanPham[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành Tiền" };
		tableModel_SanPham = new DefaultTableModel(header_SanPham, 0);
		tableSanPham = new JTable(tableModel_SanPham);
		sp_tableSanPham = new JScrollPane(tableSanPham, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp_tableSanPham.setBounds(10, 20, 818, 235);
		tableSanPham.setAutoCreateRowSorter(true);
		panel_1.add(sp_tableSanPham);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(858, 375, 477, 265);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNgayLap.setBounds(10, 70, 156, 20);
		panel_2.add(lblNgayLap);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenNV.setBounds(10, 120, 156, 20);
		panel_2.add(lblTenNV);

		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenKhachHang.setBounds(10, 170, 156, 20);
		panel_2.add(lblTenKhachHang);

		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTongTien.setBounds(10, 220, 156, 20);
		panel_2.add(lblTongTien);

		txtNgayLap = new JTextField();
		txtNgayLap.setBounds(183, 70, 238, 26);
		panel_2.add(txtNgayLap);
		txtNgayLap.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(183, 120, 238, 26);
		panel_2.add(txtTenNV);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(183, 170, 238, 26);
		panel_2.add(txtTenKH);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(183, 220, 238, 26);
		panel_2.add(txtTongTien);

		JLabel lblMaHD = new JLabel("Mã hóa đơn:");
		lblMaHD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaHD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaHD.setBounds(10, 20, 156, 20);
		panel_2.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(183, 20, 238, 26);
		panel_2.add(txtMaHD);

		btnXuatHoaDon = new JButton("Xuất hóa đơn");
		btnXuatHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXuatHoaDon.setBounds(621, 327, 131, 34);
		add(btnXuatHoaDon);

		btnXuatHoaDon.addActionListener(this);
		table_HoaDon.addMouseListener(this);
		loadTableHoaDon();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj.equals(btnXuatHoaDon)) {
			int row = table_HoaDon.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
				return;
			}

			xuatHoaDon(txtMaHD.getText().toString());
		}

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

	public void loadTableHoaDon() throws RemoteException {
		List<HoaDon> list = hoaDonService.getAllHoaDon();
		tableModel_HoaDon = (DefaultTableModel) table_HoaDon.getModel();
		for (HoaDon hoaDon : list) {
			Object[] rowData = { tableModel_HoaDon.getRowCount() + 1, hoaDon.getMaHoaDon(),
					hoaDon.getNhanVien().getHoVaTen(), hoaDon.getKhachHang().getHoVaTen(),
					new SimpleDateFormat("yyyy-MM-dd").format(hoaDon.getNgayLap()) };
			tableModel_HoaDon.addRow(rowData);
		}

	}

	public void clearTableSanPham() {
		tableModel_SanPham = (DefaultTableModel) tableSanPham.getModel();
		tableModel_SanPham.setRowCount(0);
	}
	public void clearTableHoaDon() {
		tableModel_HoaDon= (DefaultTableModel) table_HoaDon.getModel();
		tableModel_HoaDon.setRowCount(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		tableModel_HoaDon = (DefaultTableModel) table_HoaDon.getModel();
		tableModel_SanPham = (DefaultTableModel) tableSanPham.getModel();
		int row = table_HoaDon.getSelectedRow();
		long tongTien = 0;
		if (obj.equals(table_HoaDon)) {
			clearTableSanPham();
			try {
				List<ChiTietHoaDon> list = chiTietHoaDonService
						.getChiTietHoaDonByIDHoaDon(tableModel_HoaDon.getValueAt(row, 1).toString());

				for (ChiTietHoaDon chiTietHoaDon : list) {
					Object[] rowData = { tableModel_SanPham.getRowCount() + 1, chiTietHoaDon.getSanPham().getMaSP(),
							chiTietHoaDon.getSanPham().getTenSP(), chiTietHoaDon.getSanPham().tinhGiaBan(),
							chiTietHoaDon.getSoLuong(), chiTietHoaDon.getThanhTien() };
					tableModel_SanPham.addRow(rowData);
					tongTien = tongTien + chiTietHoaDon.getThanhTien();
				}

			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		txtNgayLap.setText(tableModel_HoaDon.getValueAt(row, 4).toString());
		txtTenNV.setText(tableModel_HoaDon.getValueAt(row, 2).toString());
		txtTenKH.setText(tableModel_HoaDon.getValueAt(row, 3).toString());
		txtMaHD.setText(tableModel_HoaDon.getValueAt(row, 1).toString());
		txtTongTien.setText(tongTien + "");
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
	public void filter() throws RemoteException {
		clearTableHoaDon();
		String tenKH = txtTenKH_Tim.getText().toString().trim();
		String tenNV = txtTenNV_Tim.getText().toString().trim();

		List<HoaDon> list = hoaDonService.getAllHoaDon();
		tableModel_HoaDon = (DefaultTableModel) table_HoaDon.getModel();

		for (HoaDon hoaDon : list) {
			if (hoaDon.getNhanVien().getHoVaTen().toLowerCase().contains(tenNV.toLowerCase())
					&& hoaDon.getKhachHang().getHoVaTen().toLowerCase().contains(tenKH.toLowerCase())) {
				Object[] rowData = {tableModel_HoaDon.getRowCount() + 1, hoaDon.getMaHoaDon(),
						hoaDon.getNhanVien().getHoVaTen(), hoaDon.getKhachHang().getHoVaTen(),
						new SimpleDateFormat("yyyy-MM-dd").format(hoaDon.getNgayLap()) };
				tableModel_HoaDon.addRow(rowData);
			}

		}
	}
}
