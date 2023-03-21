package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
//import dao.ChiTietHoaDonDAO;
//import dao.HoaDonDAO;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import busImp.HoaDonService_Imp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class HoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8841500185927949812L;

	@Id
    private String maHoaDon;
    
    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name="maNhanVien")
    private NhanVien nhanVien;
    
    @OneToMany(mappedBy = "hoaDon")
    private List<ChiTietHoaDon> sanPham;
    
    private Date ngayLap;
    
    
    public HoaDon() {
    }
    
    public HoaDon(HoaDon hd){
        this.khachHang = hd.getKhachHang();
        this.nhanVien = hd.getNhanVien();
        this.ngayLap = hd.getNgayLap();
    }
    
    public HoaDon(KhachHang khachHang, NhanVien nhanVien, Date ngayLap) {
//        this.maHoaDon = auto_IDHoaDon();
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayLap = ngayLap;
    }
    
    public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, Date ngayLap) {
        this.maHoaDon = maHoaDon;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayLap = ngayLap;
    }
    
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
    
    public long tongTien(){
        long tongTien = 0;
//        ChiTietHoaDonDAO cthd_DAO = new ChiTietHoaDonDAO();
//        ArrayList<ChiTietHoaDon>listChiTietHoaDon = cthd_DAO.getAllCTHDByHoaDon(this);
        
//        for(ChiTietHoaDon cthd : listChiTietHoaDon){
//            tongTien += cthd.getSoLuong();
//        }
        
        return tongTien;
    }

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon +  ", ngayLap=" + ngayLap + "]";
	}
    
    
}
