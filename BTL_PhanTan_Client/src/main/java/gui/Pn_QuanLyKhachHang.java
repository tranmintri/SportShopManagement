package gui;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import bus.KhachHangService;
import entity.KhachHang;
import entity.SanPham;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class Pn_QuanLyKhachHang extends JPanel implements MouseListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelKhachHang;
	private JTable tableKhachHang;
	private JScrollPane scrollKhachHang;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtEmail;
	private JButton btnThemKhachHang;
	private JButton btnCapNhat;
	private JComboBox<Object> cbxGioiTinh;
	private JLabel lblSDT;
	private JButton btnLuu;
	private KhachHangService khachHangService;
	private JTextField txtSDT;
	private List<KhachHang> listkhachhang;
	private JTextField txtTenTim;
	private JTextField txtSDTTim;

	public Pn_QuanLyKhachHang(int port, String host) throws MalformedURLException, RemoteException, NotBoundException {

		khachHangService = (KhachHangService) Naming.lookup("rmi://" + host + ":" + port + "/khachHangService");

		
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD, 16));
		
		setSize(1366, 630);
		// setLocation(null);
		setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(10, 11, 1334, 55);
		add(lblTitle);

		JPanel pnLoc = new JPanel();
		pnLoc.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnLoc.setBackground(new Color(255, 255, 255));
		pnLoc.setBounds(20, 315, 418, 290);
		add(pnLoc);
		pnLoc.setLayout(null);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKhachHang.setBounds(141, 10, 267, 33);
		pnLoc.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setForeground(new Color(0, 0, 0));

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenKhachHang.setForeground(new Color(0, 0, 0));
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(141, 60, 267, 33);
		pnLoc.add(txtTenKhachHang);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(141, 110, 267, 33);
		pnLoc.add(txtEmail);
//		String[] tinh = { "Thủ Đức", "Quận 1", "Quận 2", "Quận 3 ", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8",
//				"Quận 9", "Quận 10", "Quận 11", "Quận 12", "Gò Vấp", "Tân Bình", "Bình Tân", "Bình Thạnh", "Phú Nhuận",
//				"Tân Phú", "Bình Chánh", "Cần Giờ", "Củ Chi", "Hóc Môn", "Nhà Bè" };

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setBounds(10, 210, 121, 33);
		pnLoc.add(lblGioiTinh);

		JLabel lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaKhachHang.setBounds(10, 10, 121, 33);
		pnLoc.add(lblMaKhachHang);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKhachHang.setBounds(10, 60, 121, 33);
		pnLoc.add(lblTenKhachHang);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 110, 121, 33);
		pnLoc.add(lblEmail);

		cbxGioiTinh = new JComboBox<Object>(new Object[] {});
		cbxGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cbxGioiTinh.setSelectedIndex(0);
		cbxGioiTinh.setBounds(141, 210, 267, 33);
		pnLoc.add(cbxGioiTinh);

		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT.setBounds(10, 160, 121, 33);
		pnLoc.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setHorizontalAlignment(SwingConstants.CENTER);
		txtSDT.setForeground(Color.BLACK);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(141, 160, 267, 33);
		pnLoc.add(txtSDT);

		String[] cols = { "STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Giới tính", "Email" };
		modelKhachHang = new DefaultTableModel(cols, 0);
		tableKhachHang = new JTable(modelKhachHang);
		tableKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));

		scrollKhachHang = new JScrollPane(tableKhachHang);
		scrollKhachHang.setBounds(448, 76, 875, 477);
		tableKhachHang.getTableHeader().setBackground(Color.LIGHT_GRAY);
		tableKhachHang.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 17));
		tableKhachHang.setRowHeight(25);
		tableKhachHang.setBackground(Color.WHITE);
		scrollKhachHang.getViewport().setBackground(Color.WHITE);
		tableKhachHang.getTableHeader().setPreferredSize(new Dimension(0, 40));
		add(scrollKhachHang);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.LIGHT_GRAY);
		pnTimKiem.setBorder(null);
		pnTimKiem.setBounds(20, 251, 418, 64);
		add(pnTimKiem);
		pnTimKiem.setLayout(null);
		JLabel lblTimKiem = new JLabel("Thông tin khách hàng");
		lblTimKiem.setBounds(0, 0, 418, 64);
		pnTimKiem.add(lblTimKiem);
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setForeground(Color.BLACK);
		lblTimKiem.setBackground(Color.LIGHT_GRAY);

		btnThemKhachHang = new JButton("Thêm khách hàng");
		btnThemKhachHang.setIcon(new ImageIcon(Pn_QuanLyKhachHang.class.getResource("/gui/icon/add-user.png")));
		btnThemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemKhachHang.setForeground(Color.BLACK);
		btnThemKhachHang.setFont(new Font("Dialog", Font.BOLD, 16));
		btnThemKhachHang.setBounds(740, 565, 230, 40);
		add(btnThemKhachHang);

		btnCapNhat = new JButton("Cập nhật khách hàng");
		btnCapNhat.setIcon(new ImageIcon(Pn_QuanLyKhachHang.class.getResource("/gui/icon/icons-update.png")));
		btnCapNhat.setForeground(Color.BLACK);
		btnCapNhat.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCapNhat.setBounds(1053, 563, 235, 40);
		add(btnCapNhat);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(Pn_QuanLyKhachHang.class.getResource("/gui/icon/diskette.png")));
		btnLuu.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLuu.setBounds(503, 565, 128, 40);
		add(btnLuu);
		try {
			DocDuLieuTuArrayListVaoModel();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		moKhoaTextfields(false);
		btnLuu.setEnabled(false);
		tableKhachHang.addMouseListener(this);
		btnThemKhachHang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 70, 418, 171);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTenTim = new JLabel("Tên Khách Hàng:");
		lblTenTim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenTim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTenTim.setBounds(10, 38, 127, 24);
		panel.add(lblTenTim);
		
		JLabel lblSDT_Tim = new JLabel("Số điện thoại:");
		lblSDT_Tim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT_Tim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSDT_Tim.setBounds(10, 89, 127, 24);
		panel.add(lblSDT_Tim);
		
		txtTenTim = new JTextField();
		txtTenTim.setBounds(167, 42, 218, 19);
		panel.add(txtTenTim);
		txtTenTim.setColumns(10);
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
		
		txtSDTTim = new JTextField();
		txtSDTTim.setColumns(10);
		txtSDTTim.setBounds(167, 93, 218, 19);
		panel.add(txtSDTTim);
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
	}

//	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

//	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(tableKhachHang)) {
			int row = tableKhachHang.getSelectedRow();

			txtMaKhachHang.setText(tableKhachHang.getValueAt(row, 1).toString());
			KhachHang kh;
			try {
				kh = khachHangService.getKhachHangByID(txtMaKhachHang.getText());
				txtTenKhachHang.setText(kh.getHoVaTen());
				txtSDT.setText(kh.getSdt());
				cbxGioiTinh
						.setSelectedIndex(modelKhachHang.getValueAt(row, 4).toString().equalsIgnoreCase("Nam") ? 0 : 1);
				txtEmail.setText(kh.getEmail());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

//	@Override
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

	public void DocDuLieuTuArrayListVaoModel() throws Exception {
		xoaHetDuLieu();
		listkhachhang = khachHangService.getAllKhachHang();
		int i = 1;
		for (KhachHang kh : listkhachhang) {
			modelKhachHang.addRow(new Object[] { i++, kh.getMaKhachHang(), kh.getHoVaTen(), kh.getSdt(),
					kh.getGioiTinh() == false ? "Nam" : "Nữ", kh.getEmail() });

		}
	}

	public void xoaHetDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) tableKhachHang.getModel();
		dtm.getDataVector().removeAllElements();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThemKhachHang)) {
			if (btnThemKhachHang.getText().equalsIgnoreCase("Thêm khách hàng")) {
				moKhoaTextfields(true);
				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnThemKhachHang.setEnabled(true);
				clearTxtfields();
				btnThemKhachHang.setText("Huỷ");
				txtMaKhachHang.setEditable(false);
				String idPrefix = "KH";
				int length;
				try {
					length = khachHangService.getAllKhachHang().size();
					String finalId = idPrefix + String.format("%04d", length + 1);
					txtMaKhachHang.setText(finalId);		
					} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			} else if (btnThemKhachHang.getText().equalsIgnoreCase("Huỷ")) {
				moKhoaTextfields(false);
				moKhoaControls(true);
				clearTxtfields();
				btnLuu.setEnabled(false);
				txtMaKhachHang.setText("");
				btnThemKhachHang.setText("Thêm khách hàng");
			}
		} else if (obj.equals(btnLuu) && btnThemKhachHang.getText().equalsIgnoreCase("Huỷ")) {
			if (validData()) {
				KhachHang kh = revertKhachHangFromTextField();
				try {
					if (khachHangService.addKhachHang(kh) == true) {
						updateTableData(kh);
						JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
						moKhoaControls(true);
						moKhoaTextfields(false);
						btnThemKhachHang.setText("Thêm khách hàng");
					}
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "Trùng khách hàng!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (obj.equals(btnLuu) && btnCapNhat.getText().equalsIgnoreCase("Huỷ")) {
			if (validData()) {
				KhachHang kh = revertKhachHangFromTextField();
				try {
					khachHangService.updateKhachHang(kh);
					JOptionPane.showMessageDialog(this, "Cập nhật thành công khách hàng!");
					moKhoaControls(true);
					moKhoaTextfields(false);
					editOnRow();
				} catch (HeadlessException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (obj.equals(btnCapNhat)) {
			if (tableKhachHang.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Phải chọn khách hàng cần cập nhật trước!");

			} else {
				if (btnCapNhat.getText().equalsIgnoreCase("Cập nhật khách hàng")) {
					moKhoaTextfields(true);
					txtMaKhachHang.setEditable(false);
					moKhoaControls(false);
					btnLuu.setEnabled(true);
					btnCapNhat.setEnabled(true);
					btnCapNhat.setText("Huỷ");
				} else if (btnCapNhat.getText().equalsIgnoreCase("Huỷ")) {
					moKhoaTextfields(false);
					moKhoaControls(true);
					clearTxtfields();
					btnLuu.setEnabled(false);
					btnCapNhat.setText("Cập nhật khách hàng");
				}
			}

		} 

	}

	private void updateTableData(KhachHang kh) throws SQLException, RemoteException {
		listkhachhang = khachHangService.getAllKhachHang();
		int i = listkhachhang.size();
		modelKhachHang.addRow(new Object[] { i++, kh.getMaKhachHang(), kh.getHoVaTen(), kh.getSdt(),
				kh.getGioiTinh() == false ? "Nam" : "Nữ", kh.getEmail()});

	}

	private boolean validData() {
		String maKH = txtMaKhachHang.getText().trim();
		String hoten = txtTenKhachHang.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String gioitinh = cbxGioiTinh.getSelectedItem().toString();

//		if (!(maKH.length() > 0 && maKH.matches("^(KH){1}[0-9]{3}"))) {
//			JOptionPane.showMessageDialog(this, "Mã phải gồm KH  và 3 số");
//			txtMaKhachHang.requestFocus();
//			return false;
//		}
		if (!(hoten.length() > 0 && removeAccent(hoten).matches("([A-Z]{1}[a-z]+(\\s){0,1})+$"))) {
			JOptionPane.showMessageDialog(this, "Tên phải là chữ");
			txtTenKhachHang.requestFocus();
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

	private void moKhoaControls(boolean b) {
		btnCapNhat.setEnabled(b);
		btnThemKhachHang.setEnabled(b);
	}

	private void moKhoaTextfields(boolean b) {
		txtMaKhachHang.setEditable(b);
		txtTenKhachHang.setEditable(b);
		txtEmail.setEditable(b);
		txtSDT.setEditable(b);
		cbxGioiTinh.setEditable(b);
	}

	private void clearTxtfields() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		cbxGioiTinh.setSelectedIndex(0);
	}

	public KhachHang revertKhachHangFromTextField() {
		String maKH = txtMaKhachHang.getText();
		String tenKH = txtTenKhachHang.getText();
		String email = txtEmail.getText();
		String sdt = txtSDT.getText();
		boolean gioiTinh = cbxGioiTinh.getSelectedItem().toString() == "Nam" ? false : true;
		KhachHang kh = new KhachHang(maKH, tenKH, email, sdt, gioiTinh);
		return kh;
	}

	public void editOnRow() {
		int row = tableKhachHang.getSelectedRow();
		KhachHang kh = revertKhachHangFromTextField();
		tableKhachHang.setValueAt(kh.getMaKhachHang(), row, 1);
		tableKhachHang.setValueAt(kh.getHoVaTen(), row, 2);
		tableKhachHang.setValueAt(kh.getSdt(), row, 3);
		tableKhachHang.setValueAt(kh.getGioiTinh() == false ? "Nam" : "Nữ", row, 4);
		tableKhachHang.setValueAt(kh.getEmail(), row, 5);
	}

	private void showMessage(String message, JTextField txt) {
		// TODO Auto-generated method stub
		txt.requestFocus();
		JOptionPane.showMessageDialog(null, message);
	}
	public void filter() throws RemoteException {
		modelKhachHang = (DefaultTableModel) tableKhachHang.getModel();
		modelKhachHang.setRowCount(0);
		String ten = txtTenTim.getText().toString().trim();
		String sdt = txtSDTTim.getText().toString().trim();

		List<KhachHang> list = khachHangService.getAllKhachHang();
		

		for (KhachHang kh : list) {
			if (kh.getSdt().toLowerCase().contains(sdt.toLowerCase())
					&& kh.getHoVaTen().toLowerCase().contains(ten.toLowerCase())) {
				Object[] rowData = {  modelKhachHang.getRowCount() + 1, kh.getMaKhachHang(), kh.getHoVaTen(), kh.getSdt(),
						kh.getGioiTinh() == false ? "Nam" : "Nữ", kh.getEmail()  };
				modelKhachHang.addRow(rowData);
			}

		}
	}
	 private static String removeAccent(String s) {

	        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	        return pattern.matcher(temp).replaceAll("");
	    }
}
