package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import dao.KhachHangDAO;

/**
 *
 * @author 20086
 */
@Entity
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5893193963594030901L;
	@Id
    private String maKhachHang;
	@Column(columnDefinition = "nvarchar(255)")
    private String hoVaTen;
    private String email;
    private String sdt;
    private boolean gioiTinh;
    
    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDon;
    
    public KhachHang() {
    }

    
    public KhachHang(String hoVaTen, String email, String sdt, boolean gioiTinh) {
//        this.maKhachHang = auto_ID();
        this.hoVaTen = hoVaTen;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }

    
    public KhachHang(String maKhachHang, String hoVaTen, String email, String sdt, boolean gioiTinh) {
        this.maKhachHang = maKhachHang;
        this.hoVaTen = hoVaTen;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }


	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoVaTen=" + hoVaTen + ", email=" + email + ", sdt=" + sdt
				+ ", gioiTinh=" + gioiTinh + "]";
	}
   
    
}
