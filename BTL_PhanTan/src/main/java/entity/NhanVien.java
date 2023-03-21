
package entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4422586953467086948L;
	@Id
    private String maNhanVien;
	@Column(columnDefinition = "nvarchar(255)")
    private String hoVaTen;
    private Date ngaySinh;
    @Column(columnDefinition = "nvarchar(255)")
    private String diaChi;
    private String sdt;
    private boolean gioiTinh;
    private int luong;
    private String email;
    @Column(columnDefinition = "nvarchar(255)")
    private String chucVu;
    
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> dsHoaDon;
    
    @OneToOne(mappedBy = "nhanVien")
    private TaiKhoan taiKhoan;

    public NhanVien(String maNhanVien, String hoVaTen, Date ngaySinh, String diaChi, String sdt, boolean gioiTinh, int luong, String email, String chucVu) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.email = email;
        this.chucVu = chucVu;
    }
    public NhanVien() {
		// TODO Auto-generated constructor stub
	}
   

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + ", diaChi="
				+ diaChi + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", luong=" + luong + ", email=" + email
				+ ", chucVu=" + chucVu + "]";
	}
    
    
}
