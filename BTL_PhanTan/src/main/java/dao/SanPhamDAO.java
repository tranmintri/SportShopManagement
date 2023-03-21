package dao;

import java.util.ArrayList;
import java.util.List;

import dbConnection.Connection;
import entity.ChatLieu;
import entity.MauSac;
import entity.NhaCungCap;
import entity.PhanLoai;
import entity.SanPham;
import entity.XuatXu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class SanPhamDAO {

	private EntityManager em;

	public SanPhamDAO() {
		// TODO Auto-generated constructor stub
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
	}

	public boolean addSanPham(SanPham sanPham) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			em.persist(sanPham);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}

	public SanPham findSanPhamById(String id) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();

			SanPham sanPham = em.find(SanPham.class, id);

			tr.commit();
			return sanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public boolean updateSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub EntityTransaction tr = em.getTransaction();
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();

			em.merge(sanPham);

			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<SanPham> getAllSanPham() {

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT SanPham.maSP, SanPham.tenSP,  SanPham.giaNhap ,SanPham.soLuong, SanPham.hinhAnh,  SanPham.moTa, MauSac.maMauSac, XuatXu.maXuatXu,  ChatLieu.maChatLieu, PhanLoai.maPhanLoai,NhaCungCap.maNCC\r\n"
					+ "FROM     SanPham INNER JOIN\r\n"
					+ "                  XuatXu ON SanPham.maXuatXu = XuatXu.maXuatXu INNER JOIN\r\n"
					+ "                  PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai INNER JOIN\r\n"
					+ "                  NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC INNER JOIN\r\n"
					+ "                  MauSac ON SanPham.maMauSac = MauSac.maMauSac INNER JOIN\r\n"
					+ "                  ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu\r\n";
			Query query = em.createNativeQuery(sql);
			List<Object[]> list = (List<Object[]>) query.getResultList();
			List<SanPham> dsSanPham = new ArrayList();
			for (Object[] object : list) {
				SanPham sanPham = new SanPham();
//				System.out.println(object[1].toString());
				sanPham.setMaSP(object[0].toString());
				sanPham.setTenSP(object[1].toString());
				sanPham.setGiaNhap(Long.parseLong(object[2].toString()));
				sanPham.setSoLuong(Integer.parseInt(object[3].toString()));
				sanPham.setHinhAnh(object[4].toString());
				sanPham.setMoTa(object[5].toString());
				sanPham.setMauSac((MauSac) em.find(MauSac.class, object[6].toString()));
				sanPham.setXuatXu((XuatXu) em.find(XuatXu.class, object[7].toString()));
				sanPham.setChatLieu((ChatLieu) em.find(ChatLieu.class, object[8].toString()));
				sanPham.setPhanLoai((PhanLoai) em.find(PhanLoai.class, object[9].toString()));
				sanPham.setNhaCungCap((NhaCungCap) em.find(NhaCungCap.class, object[10].toString()));
				dsSanPham.add(sanPham);

			}
			tr.commit();
			return dsSanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
