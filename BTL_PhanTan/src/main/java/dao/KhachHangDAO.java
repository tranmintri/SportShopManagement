package dao;

import java.rmi.RemoteException;
import java.util.List;

import dbConnection.Connection;
import entity.KhachHang;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class KhachHangDAO {
	private EntityManager em;
	public KhachHangDAO() {
		em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
		
	}
	public boolean addKhachHang(KhachHang kh) {
 		EntityTransaction tr = em.getTransaction();
 		try {
 			tr.begin();
 			em.persist(kh);
 			tr.commit();
 			return true;
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 			tr.rollback();
 		}
 		return false;
     }
     
	public List<KhachHang> getAllKhachHang() {		
  		EntityTransaction tr = em.getTransaction();
  		try {
  			tr.begin();
  			Query query = em.createNativeQuery("Select * from KhachHang", KhachHang.class);
  			List<KhachHang> listkhachhang = query.getResultList();	 
  			tr.commit();
  			return listkhachhang ;
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  			tr.rollback();
  		}
  		return null;		
  }
   
	 public KhachHang  getKhachHangById(String maKH) {	
	 		return em.find(KhachHang.class, maKH);
	 			
	 	}
	
	 public List<KhachHang> getKhachHangByName(String hoVaTen){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
			tr.begin();
			Query query = em.createNativeQuery("select * from KhachHang where hoVaTen like concat ('%',?,'%')",KhachHang.class);
		    query.setParameter(1, hoVaTen);
		    List<KhachHang> listkhachhang = query.getResultList();
		    tr.commit();
		    return listkhachhang;
    	 } catch (Exception e) {
			// TODO: handle exception
    		 e.printStackTrace();
    		 tr.rollback();
		}
    	 return null;
     }
	 
	 public List<KhachHang> getKhachHangBySDT(String SDT){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
    		 tr.begin();
    	     Query query = em.createNativeQuery("select * from KhachHang where sdt like concat ('%',?,'%')",KhachHang.class);
    	     query.setParameter(1,SDT);     
    	     @SuppressWarnings("unchecked")
			List<KhachHang> listKhachHang =  query.getResultList();
    	     tr.commit();
    	     return listKhachHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		} 					
 		return null;
 	}
	 public KhachHang getKhachHangBySDTSingle(String SDT){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
    		 tr.begin();
    		 KhachHang khachHang = null;
    	     Query query = em.createNativeQuery("select * from KhachHang where sdt = ?",KhachHang.class);
    	     query.setParameter(1,SDT); 
    	     try {
    	    	khachHang  = (KhachHang) query.getSingleResult();
			} catch (NoResultException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	     
//    	     Object[] obj =  (Object[]) query.getSingleResult();
//    	     
//				KhachHang khachHang = new KhachHang();
//				khachHang.setMaKhachHang(obj[0].toString());
//				khachHang.setEmail(obj[1].toString());
//				khachHang.setGioiTinh(Boolean.parseBoolean( obj[2].toString()));
//				khachHang.setHoVaTen(obj[3].toString());
//				khachHang.setSdt(obj[4].toString());
			
    	     tr.commit();
    	     return khachHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
			
		} 					
    	 return null;
 	}
	 
     public KhachHang getKhachHangByEmail(String email){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
			tr.begin();
			Query query = em.createNativeQuery("select * from KhachHang where email like concat ('%',?,'%')",KhachHang.class);
		    query.setParameter(1, email);
		    KhachHang khachhang = (KhachHang) query.getSingleResult();
		    tr.commit();
		    return khachhang;
    	 } catch (Exception e) {
			// TODO: handle exception
    		 e.printStackTrace();
    		 tr.rollback();
		}
    	 return null;
     }
     public List<KhachHang> getKhachHangByIdNameEmailSDT(String maNV, String hoVaTen,  String email, String SDT){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
    		 tr.begin();
    	     Query query = em.createNativeQuery("select * from KhachHang where maKhachHang like concat ('%',?,'%') or  hoVaTen like concat ('%',?,'%') or email like concat ('%',?,'%') or sdt like concat ('%',?,'%')",KhachHang.class);
    	     query.setParameter(1,maNV); 
    	     query.setParameter(2,hoVaTen); 
    	     query.setParameter(3,email); 
    	     query.setParameter(4,SDT); 
    	     List<KhachHang> listkhachhang =  query.getResultList();
    	     tr.commit();
    	     return listkhachhang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		} 					
 		return null;
 	}
     
              
	
     public void updateKH(KhachHang kh) {
  		EntityTransaction tr = em.getTransaction();
  		try {
  			tr.begin();			
  		    em.merge(kh);
  			tr.commit();
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  			tr.rollback();
  		}  
      }
	 
	
	
	
	
	
}
