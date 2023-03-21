package dao;

import java.util.List;

import dbConnection.Connection;
import entity.MauSac;
import entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class NhaCungCapDAO {

	private EntityManager em;

	public NhaCungCapDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}
	
	public List<NhaCungCap> getAllNhaCungCap() {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from NhaCungCap", NhaCungCap.class);
			List<NhaCungCap> list = query.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public NhaCungCap getNhaCungCapByName(String name) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from NhaCungCap where tenNCC = ?", NhaCungCap.class);
			query.setParameter(1, name);
			tr.commit();
			return (NhaCungCap) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public boolean addNhaCungCap(NhaCungCap nhaCungCap) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(nhaCungCap);

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
