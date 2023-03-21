package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import busImp.NhaCungCapService_Imp;
import busImp.PhanLoaiService_Imp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import dao.PhanLoaiDAO;

/**
 *
 * @author 20086
 */
@Entity
public class PhanLoai implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5534580153778385442L;
	@Id
	private String maPhanLoai;
	@Column(columnDefinition = "nvarchar(255)")
	private String loaiSanPham;

	@OneToMany(mappedBy = "phanLoai")
	private List<SanPham> sanPham;

	public PhanLoai() {
	}

	public PhanLoai(String maPhanLoai, String loaiSanPham) {
		this.maPhanLoai = maPhanLoai;
		this.loaiSanPham = loaiSanPham;
	}

	public String getMaPhanLoai() {
		return maPhanLoai;
	}

	public void setMaPhanLoai(String maPhanLoai) {
		this.maPhanLoai = maPhanLoai;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	@Override
	public String toString() {
		return "PhanLoai [maPhanLoai=" + maPhanLoai + ", loaiSanPham=" + loaiSanPham + "]";
	}

}
