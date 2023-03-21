package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author 20086
 */
@Entity
@IdClass(ChiTietHoaDonPK.class)
public class ChiTietHoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5106692717858921636L;
	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
    private SanPham sanPham;
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon")
    private HoaDon hoaDon;
    private int soLuong;
    private long thanhTien;
    
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(SanPham sanPham, HoaDon hoaDon, int soLuong, long thanhTien) {
        this.sanPham = sanPham;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", thanhTien=" + thanhTien + "]";
	}

//    public long thanhTien(){
//        return this.soLuong * this.sanPham.tinhGiaBanLucSau();
//    }

    
    
}
