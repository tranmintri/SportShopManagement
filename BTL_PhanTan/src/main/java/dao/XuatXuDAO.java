package dao;

import java.util.List;

import dbConnection.Connection;
import entity.ChatLieu;
import entity.NhaCungCap;
import entity.XuatXu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class XuatXuDAO {

	private EntityManager em;

	public XuatXuDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}
	
	public XuatXu getXuatXuByName(String name) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from XuatXu where noiXuatXu = ?", XuatXu.class);
			query.setParameter(1, name);
			tr.commit();
			return (XuatXu) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	public List<XuatXu> getAllXuatXu() {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from XuatXu", XuatXu.class);
			List<XuatXu> list = query.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	public boolean addXuatXu(XuatXu xuatXu) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(xuatXu);

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
