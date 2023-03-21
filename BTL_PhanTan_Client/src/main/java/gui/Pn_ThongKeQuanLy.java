package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import bus.ChatLieuService;
import bus.ChiTietHoaDonService;
import bus.MauSacService;
import bus.PhanLoaiService;

public class Pn_ThongKeQuanLy extends JPanel implements ActionListener {
	private JLabel txtTieuDe;

	private NhanVien nv2;
	private JTable tableThongKe;
	private DefaultTableModel modelThongKe;

	private JScrollPane scrollThongKe;
	private JLabel lbl;

	private JMonthChooser monthChooser;

	private JYearChooser yearChooser;

	private JComboBox cb_MauSac;

	private JComboBox cb_PhanLoai;
	private JButton btnThongKe;

	private int port;
	private String host;

	private MauSacService mauSacService;

	private PhanLoaiService phanLoaiService;

	private ChiTietHoaDonService chiTietHoaDonService;

	private JLabel lblTongDoanhThu;

	private JLabel lblTongSL;

	public Pn_ThongKeQuanLy(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {
		this.port = port;
		this.host = host;

		chiTietHoaDonService = (ChiTietHoaDonService) Naming
				.lookup("rmi://" + host + ":" + port + "/chiTietHoaDonService");
		phanLoaiService = (PhanLoaiService) Naming.lookup("rmi://" + host + ":" + port + "/phanLoaiService");
		mauSacService = (MauSacService) Naming.lookup("rmi://" + host + ":" + port + "/mauSacService");

		setLayout(null);
		setSize(1345, 700);

		txtTieuDe = new JLabel("THỐNG KÊ");
		txtTieuDe.setForeground(SystemColor.desktop);
		txtTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		txtTieuDe.setFont(new Font("Tahoma", Font.BOLD, 26));
		txtTieuDe.setBounds(0, 11, 1490, 51);
		add(txtTieuDe);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(29, 72, 382, 147);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tổng số sản phẩm đã bán được");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(0, 22, 382, 27);
		panel.add(lblNewLabel);

		lblTongSL = new JLabel("0");
		lblTongSL.setForeground(SystemColor.text);
		lblTongSL.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongSL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTongSL.setBounds(0, 73, 382, 50);
		panel.add(lblTongSL);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(467, 72, 396, 147);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu");
		lblTngDoanhThu.setBounds(0, 20, 396, 26);
		lblTngDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngDoanhThu.setForeground(Color.WHITE);
		lblTngDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_1.add(lblTngDoanhThu);

		lblTongDoanhThu = new JLabel("0");
		lblTongDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongDoanhThu.setForeground(Color.WHITE);
		lblTongDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTongDoanhThu.setBounds(0, 71, 396, 50);
		panel_1.add(lblTongDoanhThu);

		String[] cols = { "Mã sản phẩm", "Tên sản phẩm", "Màu sắc", "Phân loại", "Số lượng bán được", "Doanh thu" };
		modelThongKe = new DefaultTableModel(cols, 0);
		tableThongKe = new JTable(modelThongKe);
		tableThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollThongKe = new JScrollPane(tableThongKe);
		scrollThongKe.setBounds(10, 331, 1325, 359);

		tableThongKe.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableThongKe.setAutoCreateRowSorter(true);
		tableThongKe.setRowHeight(25);
		scrollThongKe.getViewport().setBackground(Color.WHITE);
		tableThongKe.getTableHeader().setPreferredSize(new Dimension(0, 40));
		add(scrollThongKe);

		JLabel lblMauSac = new JLabel("Màu Sắc:");
		lblMauSac.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMauSac.setBounds(32, 265, 87, 30);
		add(lblMauSac);

		lbl = new JLabel("Phân Loại:");
		lbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl.setBounds(467, 265, 109, 30);
		add(lbl);

		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Times New Roman", Font.BOLD, 18));
		monthChooser.setBounds(946, 72, 160, 37);
		add(monthChooser);

		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 19));
		yearChooser.setBounds(1146, 72, 137, 37);
		add(yearChooser);

		cb_MauSac = new JComboBox();
		cb_MauSac.setBounds(129, 267, 233, 30);
		add(cb_MauSac);
		cb_MauSac.addItem("Tất cả");

		cb_PhanLoai = new JComboBox();
		cb_PhanLoai.setBounds(569, 265, 233, 30);
		add(cb_PhanLoai);
		cb_PhanLoai.addItem("Tất cả");

		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThongKe.setBounds(947, 263, 160, 30);
		add(btnThongKe);

		btnThongKe.addActionListener(this);
		loadComboBoxThuocTinh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThongKe)) {
			int month = monthChooser.getMonth() + 1;
			int year = yearChooser.getYear();
			String mauSac = cb_MauSac.getSelectedItem().toString();
			String phanLoai = cb_PhanLoai.getSelectedItem().toString();

			if (mauSac.equalsIgnoreCase("Tất cả"))
				mauSac = "";
			if (phanLoai.equalsIgnoreCase("Tất cả"))
				phanLoai = "";
			modelThongKe = (DefaultTableModel) tableThongKe.getModel();
			modelThongKe.setRowCount(0);
			int tongSanPhamBanDuoc = 0;
			long tongDoanhThu = 0l;
			try {
				List<Object[]> list = chiTietHoaDonService.getThongKeDoanhThuVaSoLuongByMonthYear(month, year);

				for (Object[] objects : list) {
					if (objects[2].toString().toLowerCase().contains(mauSac.toLowerCase())
							&& objects[3].toString().toLowerCase().contains(phanLoai.toLowerCase())) {
						Object[] rowData = { objects[0].toString(), objects[1].toString(), objects[2].toString(),
								objects[3].toString(), objects[4].toString(), objects[5].toString() };
						modelThongKe.addRow(rowData);
						tongSanPhamBanDuoc += Integer.parseInt(objects[4].toString());
						tongDoanhThu += Long.parseLong(objects[5].toString());
					}

				}
				lblTongDoanhThu.setText(tongDoanhThu + "");
				lblTongSL.setText(tongSanPhamBanDuoc + "");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void loadTableThongKe() {
		modelThongKe = (DefaultTableModel) tableThongKe.getModel();

	}

	public void loadComboBoxThuocTinh() throws RemoteException {
		mauSacService.getAllMauSac().forEach(mauSac -> cb_MauSac.addItem(mauSac.getMauSac()));

		phanLoaiService.getAllPhanLoai().forEach(phanLoai -> cb_PhanLoai.addItem(phanLoai.getLoaiSanPham()));

	}
}
