package gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pn_TrangChu extends JPanel {

	private JPanel panelHinhAnh;
	private JLabel lblHinhAnh;

	/**
	 * Create the panel.
	 */
	public Pn_TrangChu(int port) {
		setSize(1350, 700);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(804, 0, 534, 700);
		add(panel);
		panel.setLayout(null);

		JLabel lblTenHieuSach = new JLabel("Twenty Sports");
		lblTenHieuSach.setForeground(new Color(255, 255, 0));
		lblTenHieuSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenHieuSach.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblTenHieuSach.setBounds(0, 29, 565, 106);
		panel.add(lblTenHieuSach);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Pn_TrangChu.class.getResource("/gui/icon/bg2.png")));
		lblLogo.setBounds(10, 365, 510, 311);
		panel.add(lblLogo);

		JLabel lblTri = new JLabel("Trần Minh Trí");
		lblTri.setForeground(new Color(255, 255, 0));
		lblTri.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTri.setBounds(195, 160, 213, 27);
		panel.add(lblTri);

		JLabel lblDuong = new JLabel("Vũ Thái Dương");
		lblDuong.setForeground(new Color(255, 255, 0));
		lblDuong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDuong.setBounds(195, 229, 213, 27);
		panel.add(lblDuong);

		panelHinhAnh = new JPanel();
		panelHinhAnh.setBounds(0, 0, 804, 700);
		add(panelHinhAnh);
		panelHinhAnh.setLayout(null);
		

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(0, 0, 804, 700);
		panelHinhAnh.add(lblHinhAnh);
		File file = new File("");
 		lblHinhAnh.setIcon(ResizeImage(file.getAbsolutePath() + "//src//main//java//gui///icon///bg1.jpg"));

	}
	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon myImage = new ImageIcon(imgPath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(panelHinhAnh.getWidth(), panelHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}
}
