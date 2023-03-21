package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dbConnection.Connection;
import entity.PhanLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class PhanLoaiDAO extends UnicastRemoteObject implements Remote{

	private EntityManager em;

	public PhanLoaiDAO() throws RemoteException{
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}
	public List<PhanLoai> getAllPhanLoai() throws RemoteException{
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			Query query = em.createNativeQuery("Select * from PhanLoai",PhanLoai.class);
			@SuppressWarnings("unchecked")
			List<PhanLoai> list = (List<PhanLoai>)query.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public boolean addPhanLoai(PhanLoai phanLoai) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(phanLoai);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public PhanLoai findPhanLoaiById(String id) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			PhanLoai phanLoai = em.find(PhanLoai.class, id);

			tr.commit();
			return phanLoai;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	public PhanLoai getPhanLoaiByName(String name) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from PhanLoai where loaiSanPham = ?",PhanLoai.class);
			query.setParameter(1, name);
			
			tr.commit();
			return (PhanLoai) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}


	public boolean updatePhanLoai(PhanLoai phanLoai) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.merge(phanLoai);

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
