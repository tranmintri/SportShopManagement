package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.SanPhamService;
import dao.SanPhamDAO;
import entity.SanPham;

public class SanPhamService_Imp extends UnicastRemoteObject implements SanPhamService{
	
	/**
	 * 
	 */
	private SanPhamDAO sanPhamDAO;
	
	public SanPhamService_Imp() throws RemoteException{

		sanPhamDAO = new SanPhamDAO();
		
	}

	@Override
	public boolean addSanPham(SanPham sanPham) throws RemoteException{
		// TODO Auto-generated method stub
		return sanPhamDAO.addSanPham(sanPham);
	}

	@Override
	public SanPham findSanPhamById(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return sanPhamDAO.findSanPhamById(id);
	}

	@Override
	public boolean updateSanPham(SanPham sanPham) throws RemoteException{
		// TODO Auto-generated method stub
		return sanPhamDAO.updateSanPham(sanPham);
	}

	@Override
	public List<SanPham> getAllSanPham() throws RemoteException{
		// TODO Auto-generated method stub
		return sanPhamDAO.getAllSanPham();
	}

}
