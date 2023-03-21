package dao;

import java.util.List;

import dbConnection.Connection;
import entity.ChatLieu;
import entity.MauSac;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class MauSacDAO {

	private EntityManager em;

	public MauSacDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}

	public List<MauSac> getAllMauSac() {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from MauSac", MauSac.class);
			List<MauSac> list = query.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public MauSac getMauSacByName(String name) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from MauSac where mauSac = ?", MauSac.class);
			query.setParameter(1, name);
			tr.commit();
			return (MauSac) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public boolean addMauSac(MauSac mauSac) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(mauSac);

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
