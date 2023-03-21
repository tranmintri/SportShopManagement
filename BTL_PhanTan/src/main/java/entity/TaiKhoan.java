package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

//import dao.TaiKhoanDAO;

/**
 *
 * @author Admin
 */
@Entity
public class TaiKhoan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3457194620042558793L;
	@Id
	private String tenTaiKhoan;
	private String matKhau;
	private boolean loaiTaiKhoan; // 1: quan ly 0: nhan vien

	@MapsId
	@OneToOne
	@JoinColumn(name = "maNhanVien", unique = true)
	private NhanVien nhanVien;

	public TaiKhoan(String tenTaiKhoan, String matKhau, boolean loaiTaiKhoan, NhanVien nhanVien) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.nhanVien = nhanVien;
	}

	public TaiKhoan() {
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(boolean loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", loaiTaiKhoan=" + loaiTaiKhoan + "]";
	}

}
