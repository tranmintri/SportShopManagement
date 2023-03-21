package dao;

import java.util.ArrayList;
import java.util.List;

import dbConnection.Connection;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ChiTietHoaDonDAO {
	private EntityManager em;

	public ChiTietHoaDonDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}
	public boolean addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			
			Query query = em.createNativeQuery("insert into ChiTietHoaDon values (?,?,?,?)");
			query.setParameter(1, chiTietHoaDon.getHoaDon().getMaHoaDon());
			query.setParameter(2, chiTietHoaDon.getSanPham().getMaSP());
			query.setParameter(3, chiTietHoaDon.getSoLuong());
			query.setParameter(4, chiTietHoaDon.getThanhTien());
			query.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public List<ChiTietHoaDon> getChiTietHoaDonByIDHoaDon(String maHD){
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			
			Query query = em.createNativeQuery("select * from ChiTietHoaDon\r\n"
					+ "where maHoaDon = ?");
			query.setParameter(1, maHD);
			List<Object[]> list = (List<Object[]>) query.getResultList();
			List<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
			for (Object[] objects : list) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setHoaDon(em.find(HoaDon.class, objects[0].toString()));
				chiTietHoaDon.setSanPham(em.find(SanPham.class, objects[1].toString()));
				chiTietHoaDon.setSoLuong(Integer.parseInt( objects[2].toString()));
				chiTietHoaDon.setThanhTien(Long.parseLong( objects[3].toString()));
				dsChiTietHoaDon.add(chiTietHoaDon);
				
			}
			tr.commit();
			return dsChiTietHoaDon;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<Object[]> getThongKeDoanhThuVaSoLuongByMonthYear(int month, int year){
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			
			Query query = em.createNativeQuery("SELECT  ChiTietHoaDon.maSanPham, SanPham.tenSP, MauSac.mauSac, PhanLoai.loaiSanPham,SUM(ChiTietHoaDon.soLuong) AS SL,SUM(ChiTietHoaDon.thanhTien) AS DoanhThu\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  ChiTietHoaDon ON SanPham.maSP = ChiTietHoaDon.maSanPham INNER JOIN\r\n"
					+ "                  HoaDon ON HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon INNER JOIN\r\n"
					+ "                  MauSac ON SanPham.maMauSac = MauSac.maMauSac INNER JOIN\r\n"
					+ "                  PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai\r\n"
					+ "WHERE  (MONTH(HoaDon.ngayLap) = ?) AND (YEAR(HoaDon.ngayLap) = ?)\r\n"
					+ "GROUP BY ChiTietHoaDon.maSanPham, ChiTietHoaDon.soLuong, ChiTietHoaDon.thanhTien, SanPham.tenSP, MauSac.mauSac, PhanLoai.loaiSanPham");
			query.setParameter(1, month);
			query.setParameter(2, year);
			List<Object[]> list = (List<Object[]>) query.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
