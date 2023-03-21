/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

//import dao.SanPhamDAO;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import busImp.SanPhamService_Imp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class SanPham implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7919621722409080655L;
	@Id
	private String maSP;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenSP;
	private long giaNhap;
	private String hinhAnh;
	private int soLuong;
	@Column(columnDefinition = "nText")
	private String moTa;

	@ManyToOne
	@JoinColumn(name = "maChatLieu")
	private ChatLieu chatLieu;

	@ManyToOne
	@JoinColumn(name = "maMauSac")
	private MauSac mauSac;

	@ManyToOne
	@JoinColumn(name = "maXuatXu")
	private XuatXu xuatXu;

	@ManyToOne
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;

	@ManyToOne
	@JoinColumn(name = "maPhanLoai")
	private PhanLoai phanLoai;

	@OneToMany(mappedBy = "sanPham")
	private List<ChiTietHoaDon> hoaDon;

	public SanPham() {
	}

	public SanPham(String maSP, String tenSP, long giaNhap, String hinhAnh, int soLuong, String moTa, ChatLieu chatLieu,
			MauSac mauSac, XuatXu xuatXu, NhaCungCap nhaCungCap, PhanLoai phanLoai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaNhap = giaNhap;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		this.moTa = moTa;
		this.chatLieu = chatLieu;
		this.mauSac = mauSac;
		this.xuatXu = xuatXu;
		this.nhaCungCap = nhaCungCap;
		this.phanLoai = phanLoai;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public long getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(long giaNhap) {
		this.giaNhap = giaNhap;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public ChatLieu getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(ChatLieu chatLieu) {
		this.chatLieu = chatLieu;
	}

	public MauSac getMauSac() {
		return mauSac;
	}

	public void setMauSac(MauSac mauSac) {
		this.mauSac = mauSac;
	}

	public XuatXu getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(XuatXu xuatXu) {
		this.xuatXu = xuatXu;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public PhanLoai getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(PhanLoai phanLoai) {
		this.phanLoai = phanLoai;
	}

	public int tinhGiaBan() {
		return (int) (giaNhap * 1.1);
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaNhap=" + giaNhap + ", hinhAnh=" + hinhAnh
				+ ", soLuong=" + soLuong + ", moTa=" + moTa + "]";
	}



}
