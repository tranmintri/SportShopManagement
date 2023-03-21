package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import busImp.PhanLoaiService_Imp;
import busImp.XuatXuService_Imp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 *
 * @author 20086
 */
@Entity
public class XuatXu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3947172164921728269L;
	@Id
	private String maXuatXu;
	@Column(columnDefinition = "nvarchar(255)")
	private String noiXuatXu;

	@OneToMany(mappedBy = "xuatXu")
	private List<SanPham> sanPham;

	public XuatXu() {
	}

	public XuatXu(String maXuatXu, String noiXuatXu) {
		this.maXuatXu = maXuatXu;
		this.noiXuatXu = noiXuatXu;
	}

	public String getMaXuatXu() {
		return maXuatXu;
	}

	public void setMaXuatXu(String maXuatXu) {
		this.maXuatXu = maXuatXu;
	}

	public String getNoiXuatXu() {
		return noiXuatXu;
	}

	public void setNoiXuatXu(String noiXuatXu) {
		this.noiXuatXu = noiXuatXu;
	}

	@Override
	public String toString() {
		return "XuatXu [maXuatXu=" + maXuatXu + ", noiXuatXu=" + noiXuatXu + "]";
	}

}
