package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dbConnection.Connection;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class HoaDonDAO {
	private EntityManager em;

	public HoaDonDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}
	public List<HoaDon> getAllHoaDon() {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from HoaDon");
			List<Object[]> list = (List<Object[]>)query.getResultList();
			List<HoaDon> dsHoaDon = new ArrayList<>();
			for (Object[] objects : list) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(objects[0].toString());
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(objects[1].toString());
					hoaDon.setNgayLap(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hoaDon.setKhachHang(em.find(KhachHang.class,objects[2].toString() ));
				hoaDon.setNhanVien(em.find(NhanVien.class,objects[3].toString() ));
				dsHoaDon.add(hoaDon);
			}
			
			tr.commit();
			return dsHoaDon;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public boolean addHoaDon(HoaDon hoaDon) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(hoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
}
