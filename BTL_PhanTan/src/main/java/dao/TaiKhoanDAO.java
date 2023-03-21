package dao;

import java.util.ArrayList;
import java.util.List;

import dbConnection.Connection;
import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class TaiKhoanDAO {
	private EntityManager em;

	public TaiKhoanDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}
	
	public List<TaiKhoan> getAllTaiKhoan() {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("\r\n"
					+ "SELECT TaiKhoan.*\r\n"
					+ "FROM     NhanVien INNER JOIN\r\n"
					+ "TaiKhoan ON NhanVien.maNhanVien = TaiKhoan.maNhanVien");
			List<Object[]> list = (List<Object[]>) query.getResultList();
			List<TaiKhoan> dsTaiKhoan = new ArrayList();
			for (Object[] object : list) {
				TaiKhoan taiKhoan = new TaiKhoan();
				taiKhoan.setTenTaiKhoan(object[0].toString());
				taiKhoan.setLoaiTaiKhoan(Boolean.parseBoolean(object[1].toString()));
				taiKhoan.setMatKhau(object[2].toString());
				taiKhoan.setNhanVien(em.find(NhanVien.class, object[3].toString()));

				dsTaiKhoan.add(taiKhoan);

			}
			tr.commit();
			return dsTaiKhoan;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(taiKhoan);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean addTaiKhoan(TaiKhoan taiKhoan) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Insert into TaiKhoan values (?,?,?,?)");
			query.setParameter(1, taiKhoan.getTenTaiKhoan());
			query.setParameter(2, taiKhoan.getLoaiTaiKhoan());
			query.setParameter(3, taiKhoan.getMatKhau());
			query.setParameter(4, taiKhoan.getNhanVien().getMaNhanVien());
			
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
}
