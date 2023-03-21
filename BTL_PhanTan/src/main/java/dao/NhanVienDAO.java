package dao;


import java.util.List;

import dbConnection.Connection;
import entity.KhachHang;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class NhanVienDAO {
	private EntityManager em;
     public NhanVienDAO(){
		// TODO Auto-generated constructor stub	 
    	 em = Connection.getConnection().getEntityManagerFactory().createEntityManager();
		
	}
     public boolean addNhanVien(NhanVien nv) {
 		EntityTransaction tr = em.getTransaction();
 		try {
 			tr.begin();
 			em.persist(nv);
 			tr.commit();
 			return true;
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 			tr.rollback();
 		}
 		return false;
     }
     
     public List<NhanVien> getAllNhanVien() {		
  		EntityTransaction tr = em.getTransaction();
  		try {
  			tr.begin();
  			Query query = em.createNativeQuery("Select * from NhanVien", NhanVien.class);
  			List<NhanVien> listnhanvien = query.getResultList();	 
  			tr.commit();
  			return listnhanvien ;
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  			tr.rollback();
  		}
  		return null;		
  }
     
     public NhanVien  getNhanVienById(String maNV) {	
 		return em.find(NhanVien.class, maNV);
 			
 	}
     
     public List<NhanVien> getNhanVienByName(String hoVaTen){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
			tr.begin();
			Query query = em.createNativeQuery("select * from NhanVien where hoVaTen like concat ('%',?,'%')",NhanVien.class);
		    query.setParameter(1, hoVaTen);
		    List<NhanVien> listnhanvien = query.getResultList();
		    tr.commit();
		    return listnhanvien;
    	 } catch (Exception e) {
			// TODO: handle exception
    		 e.printStackTrace();
    		 tr.rollback();
		}
    	 return null;
     }
     
     public NhanVien getNhanVienByEmail(String email){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
			tr.begin();
			Query query = em.createNativeQuery("select * from NhanVien where email like concat ('%',?,'%')",NhanVien.class);
		    query.setParameter(1, email);
		    NhanVien nhanvien = (NhanVien) query.getSingleResult();
		    tr.commit();
		    return nhanvien;
    	 } catch (Exception e) {
			// TODO: handle exception
    		 e.printStackTrace();
    		 tr.rollback();
		}
  	 return null;
   }
    
             
     public List<NhanVien> getNhanVienBySDT(String SDT){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
    		 tr.begin();
    	     Query query = em.createNativeQuery("select * from NhanVien where sdt like concat ('%',?,'%')",NhanVien.class);
    	     query.setParameter(1,SDT);     
    	     List<NhanVien> listnhanvien =  query.getResultList();
    	     tr.commit();
    	     return listnhanvien;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		} 					
 		return null;
 	}
     public List<NhanVien> getNhanVienByIdNameEmailSDT(String maNV, String hoVaTen,  String email, String sdt){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
    		 tr.begin();
    	     Query query = em.createNativeQuery("select * from NhanVien where maNhanVien like concat ('%',?,'%') or  hoVaTen like concat ('%',?,'%') or sdt like concat ('%',?,'%') or email like concat ('%',?,'%')",NhanVien.class);
    	     query.setParameter(1,maNV); 
    	     query.setParameter(2,hoVaTen); 
    	     query.setParameter(3,email); 
    	     query.setParameter(4,sdt); 
    	     List<NhanVien> listnhanvien =  query.getResultList();
    	     tr.commit();
    	     return listnhanvien;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		} 					
 		return null;
 	}
     
    
     public List<NhanVien> getNhanVienByNameSDT(String hoVaTen,  String SDT){
    	 EntityTransaction tr = em.getTransaction();
    	 try {
    		 tr.begin();
    	     Query query = em.createNativeQuery("select * from NhanVien where hoVaTen like concat ('%',?,'%') or sdt like concat ('%',?,'%')",NhanVien.class);
    	     query.setParameter(1,hoVaTen); 
    	     query.setParameter(2,SDT); 
    	     List<NhanVien> listnhanvien =  query.getResultList();
    	     tr.commit();
    	     return listnhanvien;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		} 					
 		return null;
 	}         

     public void updateNV(NhanVien nv) {
 		EntityTransaction tr = em.getTransaction();
 		try {
 			tr.begin();			
 		    em.merge(nv);
 			tr.commit();
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 			tr.rollback();
 		}  
     }
}
