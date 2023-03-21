package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.NhanVienService;
import dao.NhanVienDAO;
import entity.NhanVien;

public class NhanVienService_Imp extends UnicastRemoteObject implements NhanVienService{
	private NhanVienDAO nhanvien_DAO ;
	
	public NhanVienService_Imp() throws RemoteException{
		// TODO Auto-generated constructor stub
		nhanvien_DAO = new NhanVienDAO();
	}

	@Override
	public boolean addNhanVien(NhanVien nv) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.addNhanVien(nv);
	}

	@Override
	public List<NhanVien> getAllNhanVien() throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getAllNhanVien();
	}

	@Override
	public NhanVien getNhanVienById(String maNV) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getNhanVienById(maNV);
	}

	@Override
	public List<NhanVien> getNhanVienByName(String hoVaTen) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getNhanVienByName(hoVaTen);
	}

	@Override
	public NhanVien getNhanVienByEmail(String email) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getNhanVienByEmail(email);
	}

	@Override
	public List<NhanVien> getNhanVienBySDT(String SDT) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getNhanVienBySDT(SDT);
	}

	@Override
	public List<NhanVien> getNhanVienByIdNameEmailSDT(String maNV, String hoVaTen, String email, String SDT) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getNhanVienByIdNameEmailSDT(maNV, hoVaTen, email, SDT);
	}

	@Override
	public void updateNhanVien(NhanVien nv) throws RemoteException{
		// TODO Auto-generated method stub
	 nhanvien_DAO.updateNV(nv);
	}

	@Override
	public List<NhanVien> getNhanByNameSDT(String hoVaTen, String SDT) throws RemoteException{
		// TODO Auto-generated method stub
		return nhanvien_DAO.getNhanVienByNameSDT(hoVaTen, SDT);

	

}}
