package gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import bus.NhanVienService;
import entity.NhanVien;
import entity.SanPham;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Pn_QuanLyNhanVien extends JPanel implements ActionListener, MouseListener {
	private JTextField txtMaNhanVien;
	private JTextField txtTenNV;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JScrollPane sp_tableNhanVien;
	private JTable table_NhanVien;
	private DefaultTableModel tableModel_NhanVien;
	private JPanel panel_Right;
	private JPanel panel_TitleBoLoc;
	private JLabel lblNewLabel;
	private JLabel lblTenNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblSDT;
	private JLabel lblGioiTinh;
	private JLabel lblLuong;
	private JLabel lblChucVu;
	private JLabel lblDiaChi;
	private JComboBox comboBoxGioiTinh;
	private JComboBox comboBoxChucVu;
	private JButton btnThemNV;
	private JButton btnSuaNV;
	private JPanel panelTop;
	private JLabel lblTitle;
	private JButton btnLuu;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblNgaySinh;
	private JDateChooser dateChooserNgaySinh;
	private File file = null;
	private JPanel panelTim;
	private JLabel lblMaNhanVien_1;
	private JTextField txtSDTTim;
	private JTextField txtTenTim;
	private JFileChooser filechoose;
	private NhanVienService nhanVienService;
	private List<NhanVien> listnhanvien;
	private JTextField txtLuong;
	private String host;
	private int port;

	/**
	 * Create the panel.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Pn_QuanLyNhanVien(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {
		this.host = host;
		this.port = port;
		
		nhanVienService = (NhanVienService) Naming.lookup("rmi://" + host + ":" + port + "/nhanVienService");

		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setSize(1343, 682);
		setLayout(null);

		panel_Right = new JPanel();
		panel_Right.setBounds(22, 42, 544, 603);
		add(panel_Right);
		panel_Right.setLayout(null);

		panel_TitleBoLoc = new JPanel();
		panel_TitleBoLoc.setBackground(new Color(128, 128, 128));
		panel_TitleBoLoc.setBounds(0, 0, 544, 40);
		panel_Right.add(panel_TitleBoLoc);
		panel_TitleBoLoc.setLayout(null);

		lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 544, 40);
		panel_TitleBoLoc.add(lblNewLabel);

		lblTenNhanVien = new JLabel("Tên nhân viên: ");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien.setBounds(10, 130, 93, 14);
		panel_Right.add(lblTenNhanVien);

		lblMaNhanVien = new JLabel("Mã nhân viên: ");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaNhanVien.setBounds(10, 75, 93, 14);
		panel_Right.add(lblMaNhanVien);

		lblSDT = new JLabel("Số điện thoại: ");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSDT.setBounds(10, 182, 104, 14);
		panel_Right.add(lblSDT);

		lblGioiTinh = new JLabel("Giới tính: ");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGioiTinh.setBounds(10, 236, 93, 14);
		panel_Right.add(lblGioiTinh);

		lblLuong = new JLabel("Lương: ");
		lblLuong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLuong.setBounds(10, 295, 46, 14);
		panel_Right.add(lblLuong);

		lblChucVu = new JLabel("Chức vụ: ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChucVu.setBounds(266, 236, 76, 14);
		panel_Right.add(lblChucVu);

		lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiaChi.setBounds(10, 346, 71, 14);
		panel_Right.add(lblDiaChi);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBounds(102, 73, 147, 20);
		panel_Right.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setBounds(103, 128, 147, 20);
		panel_Right.add(txtTenNV);
		txtTenNV.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setBounds(103, 180, 147, 20);
		panel_Right.add(txtSDT);
		txtSDT.setColumns(10);

		comboBoxGioiTinh = new JComboBox();
		comboBoxGioiTinh.setBounds(102, 232, 86, 22);
		comboBoxGioiTinh.addItem("Nam");
		comboBoxGioiTinh.addItem("Nữ");
		panel_Right.add(comboBoxGioiTinh);

		comboBoxChucVu = new JComboBox();
		comboBoxChucVu.setBounds(353, 232, 86, 22);
		comboBoxChucVu.addItem("Quản lý");
		comboBoxChucVu.addItem("Nhân viên");
		panel_Right.add(comboBoxChucVu);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(101, 342, 433, 23);
		panel_Right.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		txtLuong = new JTextField();
		txtLuong.setEditable(false);
		txtLuong.setColumns(10);
		txtLuong.setBounds(102, 293, 147, 20);
		panel_Right.add(txtLuong);
		txtLuong.setColumns(10);

		btnThemNV = new JButton("Thêm");
		btnThemNV.setIcon(new ImageIcon(Pn_QuanLyNhanVien.class.getResource("/gui/icon/add-user.png")));
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemNV.setBounds(71, 549, 117, 32);
		panel_Right.add(btnThemNV);

		btnSuaNV = new JButton("Sửa");
		btnSuaNV.setIcon(new ImageIcon(Pn_QuanLyNhanVien.class.getResource("/gui/icon/contract.png")));
		btnSuaNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaNV.setBounds(225, 549, 117, 32);
		panel_Right.add(btnSuaNV);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(Pn_QuanLyNhanVien.class.getResource("/gui/icon/diskette.png")));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLuu.setBounds(380, 549, 117, 32);
		panel_Right.add(btnLuu);

		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(266, 75, 46, 14);
		panel_Right.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(350, 73, 147, 20);
		panel_Right.add(txtEmail);
		txtEmail.setColumns(10);

		lblNgaySinh = new JLabel("Ngày sinh: ");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgaySinh.setBounds(260, 130, 76, 14);
		panel_Right.add(lblNgaySinh);

		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(350, 130, 147, 20);
		panel_Right.add(dateChooserNgaySinh);

		panelTim = new JPanel();
		panelTim.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTim.setBounds(44, 401, 449, 120);
		panel_Right.add(panelTim);
		panelTim.setLayout(null);

		lblMaNhanVien_1 = new JLabel("Số điện thoại: ");
		lblMaNhanVien_1.setBounds(44, 34, 81, 14);
		lblMaNhanVien_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelTim.add(lblMaNhanVien_1);

		txtSDTTim = new JTextField();
		txtSDTTim.setColumns(10);
		txtSDTTim.setBounds(206, 31, 147, 20);
		panelTim.add(txtSDTTim);
		txtSDTTim.addKeyListener(new KeyListener() {

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


		txtTenTim = new JTextField();
		txtTenTim.setColumns(10);
		txtTenTim.setBounds(206, 74, 147, 20);
		panelTim.add(txtTenTim);
		txtTenTim.addKeyListener(new KeyListener() {

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

		JLabel lblTenNhanVien_1 = new JLabel("Tên nhân viên: ");
		lblTenNhanVien_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNhanVien_1.setBounds(44, 77, 93, 14);
		panelTim.add(lblTenNhanVien_1);

		panelTop = new JPanel();
		panelTop.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelTop.setBounds(580, 42, 763, 603);
		add(panelTop);

		lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 1343, 44);
		add(lblTitle);

		panelTop.setLayout(null);
		String header_NhanVien[] = { "STT", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Số điện thoại", "Giới tính",
				"Lương", "Email", "Chức vụ", "Địa chỉ" };
		tableModel_NhanVien = new DefaultTableModel(header_NhanVien, 0);
		table_NhanVien = new JTable(tableModel_NhanVien);
		sp_tableNhanVien = new JScrollPane(table_NhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp_tableNhanVien.setBounds(10, 21, 743, 572);
		table_NhanVien.setAutoCreateRowSorter(true);
		panelTop.add(sp_tableNhanVien);

		table_NhanVien.getColumnModel().getColumn(0).setPreferredWidth(20);
		table_NhanVien.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_NhanVien.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_NhanVien.getColumnModel().getColumn(3).setPreferredWidth(70);
		table_NhanVien.getColumnModel().getColumn(4).setPreferredWidth(70);
		table_NhanVien.getColumnModel().getColumn(5).setPreferredWidth(40);
		table_NhanVien.getColumnModel().getColumn(6).setPreferredWidth(40);
		table_NhanVien.getColumnModel().getColumn(7).setPreferredWidth(50);
		table_NhanVien.getColumnModel().getColumn(8).setPreferredWidth(220);

		table_NhanVien.addMouseListener(this);
		try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		moKhoaTextfields(false);
		btnLuu.setEnabled(false);
		txtSDTTim.setEditable(true);
		txtTenTim.setEditable(true);

		btnThemNV.addActionListener(this);
		btnSuaNV.addActionListener(this);
		btnLuu.addActionListener(this);

	}

//-------------------------------------------------//
//	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(table_NhanVien)) {
			int row = table_NhanVien.getSelectedRow();
			try {
				DefaultTableModel model = (DefaultTableModel) table_NhanVien.getModel();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(row, 3).toString());

				dateChooserNgaySinh.setDate(date);

				dateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("sai");
			}
			txtMaNhanVien.setText(tableModel_NhanVien.getValueAt(row, 1).toString());
			NhanVien nv;
			try {
				nv = nhanVienService.getNhanVienById(txtMaNhanVien.getText());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			txtTenNV.setText(tableModel_NhanVien.getValueAt(row, 2).toString());
			txtSDT.setText(tableModel_NhanVien.getValueAt(row, 4).toString());

			comboBoxGioiTinh.setSelectedIndex(
					tableModel_NhanVien.getValueAt(row, 5).toString().equalsIgnoreCase("Nam") ? 0 : 1);
			txtLuong.setText(tableModel_NhanVien.getValueAt(row, 6).toString());
			txtEmail.setText(tableModel_NhanVien.getValueAt(row, 7).toString());
			comboBoxChucVu.setSelectedIndex(
					tableModel_NhanVien.getValueAt(row, 8).toString().equalsIgnoreCase("Quản lý") ? 0 : 1);
			txtDiaChi.setText(tableModel_NhanVien.getValueAt(row, 9).toString());

		}

	}

//	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	// @Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

//	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

//	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThemNV)) {
			if (btnThemNV.getText().equalsIgnoreCase("Thêm")) {
				String idPrefix = "NV";
				int length;
				try {
					length = nhanVienService.getAllNhanVien().size();
					String finalId = idPrefix + String.format("%04d", length + 1);
					txtMaNhanVien.setText(finalId);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				moKhoaTextfields(true);
				btnThemNV.setText("Hủy");
				btnLuu.setEnabled(true);
				btnSuaNV.setEnabled(false);
			} else if (btnThemNV.getText().equalsIgnoreCase("Hủy")) {
				moKhoaTextfields(false);
				btnLuu.setEnabled(false);
				btnSuaNV.setEnabled(true);
				clearTxtfields();
				btnLuu.setEnabled(false);
				btnThemNV.setText("Thêm");
				txtMaNhanVien.setText("");
			}
		} else if (obj.equals(btnLuu) && btnThemNV.getText().equalsIgnoreCase("Hủy")) {
			if (validData()) {
				NhanVien nv = revertNhanVienFromTextfields();
				
			
				try {

					if (nhanVienService.addNhanVien(nv) == true) {
						updateTableData(nv);
						JOptionPane.showMessageDialog(this, "Thêm thành công nhân viên!");
						btnLuu.setEnabled(false);
						btnSuaNV.setEnabled(true);
						moKhoaTextfields(false);
						btnThemNV.setText("Thêm");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "Trùng thông tin!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					FrmThemTaiKhoan frmThemTK = new FrmThemTaiKhoan(nv,port,host);
					frmThemTK.setVisible(true);
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
			}
		} else if (obj.equals(btnLuu) && btnSuaNV.getText().equalsIgnoreCase("Hủy")) {
			if (validData()) {
				NhanVien nv = revertNhanVienFromTextfields();
				try {
					nhanVienService.updateNhanVien(nv);
					JOptionPane.showMessageDialog(this, "Cập nhật thành công thông tin nhân viên!");
					btnLuu.setEnabled(false);
					btnSuaNV.setEnabled(true);
					moKhoaTextfields(false);
					editOnRow();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (obj.equals(btnSuaNV)) {
			if (table_NhanVien.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Phải chọn dòng trước khi sửa");
			} else {
				if (btnSuaNV.getText().equalsIgnoreCase("Sửa")) {
					moKhoaTextfields(true);
					btnLuu.setEnabled(false);
					btnSuaNV.setEnabled(true);
					btnLuu.setEnabled(true);
					btnSuaNV.setEnabled(true);
					btnSuaNV.setText("Hủy");
				} else if (btnSuaNV.getText().equalsIgnoreCase("Hủy")) {
					moKhoaTextfields(false);
					btnLuu.setEnabled(false);
					btnSuaNV.setEnabled(true);
					clearTxtfields();
					btnLuu.setEnabled(false);
					btnSuaNV.setText("Sửa");

				}
			}
		}

	}

	private boolean validData() {
		String maNV = txtMaNhanVien.getText().trim();
		String hoten = txtTenNV.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String gioitinh = comboBoxGioiTinh.getSelectedItem().toString();

		if (!(hoten.length() > 0 && removeAccent(hoten).matches("([A-Z]{1}[a-z]+(\\s){0,1})+$"))) {
			JOptionPane.showMessageDialog(this, "Tên phải là chữ");
			txtTenNV.requestFocus();
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}"))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
			txtSDT.requestFocus();
			return false;
		}
		if (!(email.length() > 0 && email.matches("[a-zA-Z0-9._%-]+(@){1}[a-zA-Z]+(.){1}[a-zA-Z]{2,4}"))) {
			JOptionPane.showMessageDialog(this, "Email sai định dạng");
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}

	public void DocDuLieuTuArrayListVaoModel() throws Exception {
		listnhanvien = nhanVienService.getAllNhanVien();
		int i = 1;
		for (NhanVien nv : listnhanvien) {

			tableModel_NhanVien.addRow(new Object[] { i++, nv.getMaNhanVien(), nv.getHoVaTen(), nv.getNgaySinh(),
					nv.getSdt(), nv.getGioiTinh() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getEmail(), nv.getChucVu(),
					nv.getDiaChi() });
		}
	}

	private void updateTableData(NhanVien nv) throws SQLException, RemoteException {
		listnhanvien = nhanVienService.getAllNhanVien();
		int i = listnhanvien.size();
		tableModel_NhanVien.addRow(new Object[] { i++, nv.getMaNhanVien(), nv.getHoVaTen(), nv.getNgaySinh(),
				nv.getSdt(), nv.getGioiTinh() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getEmail(), nv.getChucVu(),
				nv.getDiaChi() });
	}

	public void editOnRow() {
		int row = table_NhanVien.getSelectedRow();
		NhanVien nv = revertNhanVienFromTextfields();

		table_NhanVien.setValueAt(nv.getMaNhanVien(), row, 1);
		table_NhanVien.setValueAt(nv.getHoVaTen(), row, 2);
		table_NhanVien.setValueAt(nv.getNgaySinh(), row, 3);
		table_NhanVien.setValueAt(nv.getSdt(), row, 4);
		table_NhanVien.setValueAt(nv.getGioiTinh() == true ? "Nam" : "Nữ", row, 5);
		table_NhanVien.setValueAt(nv.getLuong(), row, 6);
		table_NhanVien.setValueAt(nv.getEmail(), row, 7);
		table_NhanVien.setValueAt(nv.getChucVu(), row, 8);
		table_NhanVien.setValueAt(nv.getDiaChi(), row, 9);

	}

	public NhanVien revertNhanVienFromTextfields() {
		String maNV = txtMaNhanVien.getText();
		String tenNV = txtTenNV.getText();
		Date ngaySinh = dateChooserNgaySinh.getDate();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		boolean gioiTinh = comboBoxGioiTinh.getSelectedItem().toString() == "Nam" ? false : true;
		String chucVu = comboBoxChucVu.getSelectedItem().toString();
		int luong = Integer.parseInt(txtLuong.getText());

		NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, sdt, gioiTinh, luong, email, chucVu);
		return nv;
	}

	private void moKhoaTextfields(boolean b) {
		txtTenNV.setEditable(b);
		txtDiaChi.setEditable(b);
		txtSDT.setEditable(b);
		txtLuong.setEditable(b);
		comboBoxChucVu.setEditable(b);
		txtSDTTim.setEditable(b);
		txtTenTim.setEditable(b);
		txtEmail.setEditable(b);

	}

	private void clearTxtfields() {
		txtMaNhanVien.setText("");
		txtTenNV.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtLuong.setText("");
		comboBoxChucVu.setSelectedIndex(0);
		txtSDTTim.setText("");
		txtTenTim.setText("");
		txtEmail.setText("");
	}

	public void xoaHetDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) table_NhanVien.getModel();
		dtm.getDataVector().removeAllElements();
	}
	public void filter() throws RemoteException {
		tableModel_NhanVien = (DefaultTableModel) table_NhanVien.getModel();
		tableModel_NhanVien.setRowCount(0);
		String sdt = txtSDTTim.getText().toString().trim();
		String ten = txtTenTim.getText().toString().trim();

		List<NhanVien> list = nhanVienService.getAllNhanVien();

		for (NhanVien nv : list) {
			if (nv.getSdt().toLowerCase().contains(sdt.toLowerCase())
					&& nv.getHoVaTen().toLowerCase().contains(ten.toLowerCase())) {
				Object[] rowData = {  tableModel_NhanVien.getRowCount()+1, nv.getMaNhanVien(), nv.getHoVaTen(), nv.getNgaySinh(),
						nv.getSdt(), nv.getGioiTinh() == false ? "Nam" : "Nữ", nv.getLuong(), nv.getEmail(), nv.getChucVu(),
								nv.getDiaChi()  };
				tableModel_NhanVien.addRow(rowData);
			}

		}
	}
	 private static String removeAccent(String s) {

	        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	        return pattern.matcher(temp).replaceAll("");
	    }
}
