package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.FinalComponent;

import bus.ChatLieuService;
import bus.MauSacService;
import bus.NhaCungCapService;
import bus.PhanLoaiService;
import bus.XuatXuService;
import entity.ChatLieu;
import entity.MauSac;
import entity.NhaCungCap;
import entity.PhanLoai;
import entity.XuatXu;

import java.awt.Color;
import java.awt.Dimension;
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
import java.util.List;

import javax.swing.JRadioButton;
import javax.sound.sampled.Port;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Frm_QuanLyThuocTinh extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private DefaultTableModel modelThuocTinh;
	private JTable tableThuocTinh;
	private JScrollPane scrollThuocTinh;
	private JLabel lblMa;
	private JLabel lblTen;
	private JRadioButton radPhanLoai;
	private JRadioButton radXuatXu;
	private JRadioButton radChatLieu;
	private JRadioButton radNhaCungCap;
	private JRadioButton radMauSac;
	private JButton btnThem;
	private String loaiSanPham;
	private JLabel lblTitle;
	private JButton btnHuy;
	private JButton btnLuu;
	private ButtonGroup group;
	private JTextField txtEmail;
	private JTextField txtSdt;
	private JLabel lblSdt;
	private JLabel lblEmail;
	private JTextField txtDiaChi;
	private JLabel lblDiaChi;

	private PhanLoaiService phanLoaiService;
	private ChatLieuService chatLieuService;
	private MauSacService mauSacService;
	private XuatXuService xuatXuService;
	private NhaCungCapService nhaCungCapService;

	public Frm_QuanLyThuocTinh(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {
		
		phanLoaiService = (PhanLoaiService) Naming.lookup("rmi://"+host+":" + port + "/phanLoaiService");
		chatLieuService = (ChatLieuService) Naming.lookup("rmi://"+host+":" + port + "/chatLieuService");
		mauSacService = (MauSacService) Naming.lookup("rmi://"+host+":" + port + "/mauSacService");
		xuatXuService = (XuatXuService) Naming.lookup("rmi://"+host+":" + port + "/xuatXuService");
		nhaCungCapService = (NhaCungCapService) Naming.lookup("rmi://"+host+":" + port + "/nhaCungCapService");

		setResizable(false);
		setSize(1000, 600);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMa.setBounds(237, 54, 233, 28);
		getContentPane().add(txtMa);
		txtMa.setColumns(10);

		lblTitle = new JLabel("QUẢN LÝ THUỘC TÍNH");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 966, 28);
		getContentPane().add(lblTitle);

		lblMa = new JLabel("Mã Phân Loại:");
		lblMa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMa.setBounds(10, 52, 218, 28);
		getContentPane().add(lblMa);

		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setColumns(10);
		txtTen.setBounds(237, 95, 233, 28);
		getContentPane().add(txtTen);

		lblTen = new JLabel("Tên Phân Loại");
		lblTen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTen.setBounds(10, 93, 218, 28);
		getContentPane().add(lblTen);
		
		String[] cols = { "Mã", "Tên" };
		modelThuocTinh = new DefaultTableModel(cols, 0);
		tableThuocTinh = new JTable(modelThuocTinh);
		tableThuocTinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableThuocTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollThuocTinh = new JScrollPane(tableThuocTinh);
		scrollThuocTinh.setBounds(10, 256, 966, 297);

		tableThuocTinh.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableThuocTinh.setAutoCreateRowSorter(true);
		tableThuocTinh.setRowHeight(25);
		scrollThuocTinh.getViewport().setBackground(Color.WHITE);
		tableThuocTinh.getTableHeader().setPreferredSize(new Dimension(0, 40));
		getContentPane().add(scrollThuocTinh);

		radPhanLoai = new JRadioButton("Phân Loại");
		radPhanLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radPhanLoai.setBounds(525, 54, 133, 21);
		getContentPane().add(radPhanLoai);

		radXuatXu = new JRadioButton("Xuất Xứ");
		radXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radXuatXu.setBounds(525, 95, 128, 21);
		getContentPane().add(radXuatXu);

		radChatLieu = new JRadioButton("Chất Liệu");
		radChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radChatLieu.setBounds(668, 57, 128, 21);
		getContentPane().add(radChatLieu);

		radNhaCungCap = new JRadioButton("Nhà Cung Cấp");
		radNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radNhaCungCap.setBounds(668, 98, 141, 21);
		getContentPane().add(radNhaCungCap);

		radMauSac = new JRadioButton("Màu sắc");
		radMauSac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radMauSac.setBounds(837, 57, 91, 21);
		getContentPane().add(radMauSac);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(525, 133, 122, 28);
		getContentPane().add(btnThem);
		radPhanLoai.setSelected(true);
		group = new ButtonGroup();
		group.add(radXuatXu);
		group.add(radPhanLoai);
		group.add(radMauSac);
		group.add(radNhaCungCap);
		group.add(radChatLieu);

		btnHuy = new JButton("Thoát");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBounds(816, 133, 122, 28);
		getContentPane().add(btnHuy);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(237, 171, 233, 28);
		getContentPane().add(txtEmail);

		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(10, 169, 218, 28);
		getContentPane().add(lblEmail);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setEditable(false);
		txtSdt.setColumns(10);
		txtSdt.setBounds(237, 133, 233, 28);
		getContentPane().add(txtSdt);

		lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSdt.setBounds(10, 131, 218, 28);
		getContentPane().add(lblSdt);
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(237, 209, 400, 28);
		getContentPane().add(txtDiaChi);

		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiaChi.setBounds(10, 207, 218, 28);
		getContentPane().add(lblDiaChi);
		lblEmail.setVisible(false);
		lblSdt.setVisible(false);
		lblDiaChi.setVisible(false);
		txtEmail.setVisible(false);
		txtSdt.setVisible(false);
		txtDiaChi.setVisible(false);
		btnThem.addActionListener(this);
		btnHuy.addActionListener(this);
		radXuatXu.addMouseListener(this);
		radPhanLoai.addMouseListener(this);
		radMauSac.addMouseListener(this);
		radNhaCungCap.addMouseListener(this);
		radChatLieu.addMouseListener(this);
		tableThuocTinh.addMouseListener(this);

		radPhanLoai.setSelected(true);

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(674, 133, 122, 28);
		getContentPane().add(btnLuu);

		btnLuu.addActionListener(this);
		xoaTable();
		loadDuLieuPhanLoai();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(radPhanLoai)) {
			lblMa.setText("Mã Phân Loại");
			lblTen.setText("Tên Phân Loại");
			lblEmail.setVisible(false);
			lblSdt.setVisible(false);
			lblDiaChi.setVisible(false);
			txtEmail.setVisible(false);
			txtDiaChi.setVisible(false);
			txtSdt.setVisible(false);
			xoaTrang();
			String[] col = { "Mã", "Tên" };

			modelThuocTinh.setColumnIdentifiers(col);

			xoaTable();
			try {
				loadDuLieuPhanLoai();
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
		if (o.equals(radChatLieu)) {
			lblMa.setText("Mã Chất Liệu");
			lblTen.setText("Tên Chất Liệu");
			lblEmail.setVisible(false);
			lblSdt.setVisible(false);
			lblDiaChi.setVisible(false);
			txtEmail.setVisible(false);
			txtDiaChi.setVisible(false);
			txtSdt.setVisible(false);
			xoaTrang();

			String[] col = { "Mã", "Tên" };

			modelThuocTinh.setColumnIdentifiers(col);
			xoaTable();
			try {
				loadDuLieuChatLieu();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(radMauSac)) {
			lblMa.setText("Mã Màu Sắc ");
			lblTen.setText("Tên Màu Sắc");
			lblEmail.setVisible(false);
			lblSdt.setVisible(false);
			lblDiaChi.setVisible(false);
			txtEmail.setVisible(false);
			txtDiaChi.setVisible(false);
			txtSdt.setVisible(false);
			xoaTrang();

			String[] col = { "Mã", "Tên" };

			modelThuocTinh.setColumnIdentifiers(col);
			xoaTable();
			try {
				loadDuLieuMauSac();
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
		if (o.equals(radXuatXu)) {
			lblMa.setText("Mã Xuất Xứ");
			lblTen.setText("Tên Xuất Xứ");
			lblEmail.setVisible(false);
			lblSdt.setVisible(false);
			lblDiaChi.setVisible(false);
			txtEmail.setVisible(false);
			txtDiaChi.setVisible(false);
			txtSdt.setVisible(false);
			xoaTrang();
			String[] col = { "Mã", "Tên" };

			modelThuocTinh.setColumnIdentifiers(col);
			xoaTable();
			try {
				loadDuLieuXuatXu();
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

			;
		}
		if (o.equals(radNhaCungCap)) {
			lblMa.setText("Mã Nhà Cung Cấp");
			lblTen.setText("Tên Nhà Cung Cấp");
			lblEmail.setVisible(true);
			lblSdt.setVisible(true);
			lblDiaChi.setVisible(true);
			txtEmail.setVisible(true);
			txtDiaChi.setVisible(true);
			txtSdt.setVisible(true);
			xoaTrang();

			String[] col = { "Mã", "Tên", "Email", "SĐT", "Địa Chỉ" };

			modelThuocTinh.setColumnIdentifiers(col);
			xoaTable();
			try {
				loadDuLieuNhaCungCap();
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
		if (o.equals(tableThuocTinh)) {
			int row = tableThuocTinh.getSelectedRow();
			modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
			txtMa.setText(modelThuocTinh.getValueAt(row, 0).toString());
			txtTen.setText(modelThuocTinh.getValueAt(row, 1).toString());
			if (radNhaCungCap.isSelected()) {
				txtEmail.setText(modelThuocTinh.getValueAt(row, 2).toString());
				txtSdt.setText(modelThuocTinh.getValueAt(row, 3).toString());
				txtDiaChi.setText(modelThuocTinh.getValueAt(row, 4).toString());
			}
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

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem) && btnThem.getText().equalsIgnoreCase("Thêm")) {
			radioButtonIsActive(false);
			xoaTrang();
			btnThem.setText("Hủy");
			btnLuu.setEnabled(true);
			moKhoaTextField(true);

			if (radPhanLoai.isSelected()) {

				String idPrefix = "PL";
				int length;
				try {
					length = phanLoaiService.getAllPhanLoai().size();
					String finalId = idPrefix + String.format("%04d", length + 1);
					txtMa.setText(finalId);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
			if (radChatLieu.isSelected()) {

				String idPrefix = "CL";
				int length;
				try {
					length = chatLieuService.getAllChatLieu().size();
					String finalId = idPrefix + String.format("%04d", length + 1);
					txtMa.setText(finalId);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String[] col = { "Mã", "Tên" };

			}
			if (radMauSac.isSelected()) {

				String idPrefix = "MS";
				int length;
				try {
					length = mauSacService.getAllMauSac().size();
					String finalId = idPrefix + String.format("%04d", length + 1);
					txtMa.setText(finalId);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
			if (radXuatXu.isSelected()) {

				String idPrefix = "XX";
				int length;
				try {
					length = xuatXuService.getAllXuatXu().size();
					String finalId = idPrefix + String.format("%04d", length + 1);
					txtMa.setText(finalId);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			if (radNhaCungCap.isSelected()) {

				String idPrefix = "NCC";
				int length;
				try {
					length = nhaCungCapService.getAllNhaCungCap().size();
					String finalId = idPrefix + String.format("%03d", length + 1);
					txtMa.setText(finalId);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}

		} else if (o.equals(btnThem) && btnThem.getText().equalsIgnoreCase("Hủy")) {
			moKhoaTextField(false);
			radioButtonIsActive(true);
			btnLuu.setEnabled(false);
			btnThem.setText("Thêm");
			group.clearSelection();
			modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
			modelThuocTinh.setRowCount(0);
			xoaTrang();
		} else if (o.equals(btnLuu)) {

			if (radNhaCungCap.isSelected()) {
				NhaCungCap nhaCungCap = null;
				try {
					nhaCungCap = (NhaCungCap) loadDataFromTextField();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					if (nhaCungCapService.addNhaCungCap(nhaCungCap)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (radChatLieu.isSelected()) {
				ChatLieu chatLieu = null;
				try {
					chatLieu = (ChatLieu) loadDataFromTextField();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					if (chatLieuService.addChatLieu(chatLieu)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (radMauSac.isSelected()) {
				MauSac mauSac = null;
				try {
					mauSac = (MauSac) loadDataFromTextField();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					if (mauSacService.addMauSac(mauSac)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (radXuatXu.isSelected()) {
				XuatXu xuatXu = null;
				try {
					xuatXu = (XuatXu) loadDataFromTextField();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					if (xuatXuService.addXuatXu(xuatXu)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (radPhanLoai.isSelected()) {
				PhanLoai phanLoai = null;
				try {
					phanLoai = (PhanLoai) loadDataFromTextField();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					if (phanLoaiService.addPhanLoai(phanLoai)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm thất bại");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			xoaTrang();
			radioButtonIsActive(true);
			moKhoaTextField(false);
			;
			btnLuu.setEnabled(false);

			btnThem.setText("Thêm");
		} else if (o.equals(btnHuy)) {
			this.setVisible(false);
		}

	}

	public void moKhoaTextField(boolean isActive) {
		txtDiaChi.setEditable(isActive);
		txtEmail.setEditable(isActive);
		txtTen.setEditable(isActive);
		txtSdt.setEditable(isActive);
	}

	public void xoaTable() {
		modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
		modelThuocTinh.setRowCount(0);
	}

	public void loadDuLieuPhanLoai() throws MalformedURLException, RemoteException, NotBoundException {

		List<PhanLoai> list = phanLoaiService.getAllPhanLoai();

		modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
		for (PhanLoai phanLoai : list) {
			Object[] rowData = { phanLoai.getMaPhanLoai(), phanLoai.getLoaiSanPham() };
			modelThuocTinh.addRow(rowData);
		}
	}

	public void loadDuLieuChatLieu() throws RemoteException, MalformedURLException, NotBoundException {

		List<ChatLieu> list = chatLieuService.getAllChatLieu();

		modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
		for (ChatLieu chatLieu : list) {
			Object[] rowData = { chatLieu.getMaChatLieu(), chatLieu.getChatLieu() };
			modelThuocTinh.addRow(rowData);
		}
	}

	public void loadDuLieuMauSac() throws MalformedURLException, RemoteException, NotBoundException {

		List<MauSac> list = mauSacService.getAllMauSac();

		modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
		for (MauSac mauSac : list) {
			Object[] rowData = { mauSac.getMaMauSac(), mauSac.getMauSac() };
			modelThuocTinh.addRow(rowData);
		}
	}

	public void loadDuLieuXuatXu() throws MalformedURLException, RemoteException, NotBoundException {

		List<XuatXu> list = xuatXuService.getAllXuatXu();

		modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
		for (XuatXu xuatXu : list) {
			Object[] rowData = { xuatXu.getMaXuatXu(), xuatXu.getNoiXuatXu() };
			modelThuocTinh.addRow(rowData);
		}
	}

	public void loadDuLieuNhaCungCap() throws MalformedURLException, RemoteException, NotBoundException {

		List<NhaCungCap> list = nhaCungCapService.getAllNhaCungCap();

		modelThuocTinh = (DefaultTableModel) tableThuocTinh.getModel();
		for (NhaCungCap nhaCungCap : list) {
			Object[] rowData = { nhaCungCap.getMaNCC(), nhaCungCap.getTenNCC(), nhaCungCap.getEmail(),
					nhaCungCap.getsDT(), nhaCungCap.getDiaChi() };
			modelThuocTinh.addRow(rowData);
		}
	}

	public Object loadDataFromTextField() throws RemoteException {

		String ma = txtMa.getText().toString().trim();
		String ten = txtTen.getText().toString().trim();
		if (radNhaCungCap.isSelected()) {
			String email = txtEmail.getText().toString().trim();
			String soDT = txtSdt.getText().toString().trim();
			String diaChi = txtDiaChi.getText().toString().trim();
			NhaCungCap nhaCungCap = new NhaCungCap(ma, ten, diaChi, email, soDT);
			return nhaCungCap;
		}
		if (radChatLieu.isSelected()) {
			ChatLieu chatLieu = new ChatLieu(ma, ten);
			return chatLieu;
		}
		if (radMauSac.isSelected()) {
			MauSac mauSac = new MauSac(ma, ten);
			return mauSac;
		}
		if (radXuatXu.isSelected()) {
			XuatXu xuatXu = new XuatXu(ma, ten);
			return xuatXu;
		}
		if (radPhanLoai.isSelected()) {
			PhanLoai phanLoai = new PhanLoai(ma, ten);
			return phanLoai;
		}
		return null;
	}

	public void radioButtonIsActive(boolean isActive) {
		radChatLieu.setEnabled(isActive);
		radPhanLoai.setEnabled(isActive);
		radMauSac.setEnabled(isActive);
		radXuatXu.setEnabled(isActive);
		radNhaCungCap.setEnabled(isActive);
	}

	public void xoaTrang() {
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtTen.setText("");
		txtSdt.setText("");
		txtMa.setText("");
	}
}
