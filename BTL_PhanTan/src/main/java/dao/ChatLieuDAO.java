package dao;

import java.util.List;

import dbConnection.Connection;
import entity.ChatLieu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ChatLieuDAO {

	private EntityManager em;

	public ChatLieuDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}

	public boolean addChatLieu(ChatLieu chatLieu) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(chatLieu);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}

	public ChatLieu findChatLieuById(String id) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			ChatLieu chatLieu = em.find(ChatLieu.class,id);

			tr.commit();
			return chatLieu;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public ChatLieu findChatLieuByName(String name) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from ChatLieu where chatLieu = ?", ChatLieu.class);
			query.setParameter(1, name);
			tr.commit();
			return (ChatLieu) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public boolean updateChatLieu(ChatLieu chatLieu) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.merge(chatLieu);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<ChatLieu> getAllChatLieu() {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			Query query = em.createNativeQuery("Select * from ChatLieu", ChatLieu.class);
			List<ChatLieu> list = query.getResultList();
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
