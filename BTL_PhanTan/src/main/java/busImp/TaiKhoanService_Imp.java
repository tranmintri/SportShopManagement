package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.TaiKhoanService;
import dao.TaiKhoanDAO;
import entity.TaiKhoan;

public class TaiKhoanService_Imp extends UnicastRemoteObject implements TaiKhoanService{

	private TaiKhoanDAO taiKhoanDAO;
	
	public TaiKhoanService_Imp() throws RemoteException{

		taiKhoanDAO = new TaiKhoanDAO();
		
	}
	
	@Override
	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException{
		// TODO Auto-generated method stub
		return taiKhoanDAO.getAllTaiKhoan();
	}

	@Override
	public boolean updateTaiKhoan(TaiKhoan taiKhoan) throws RemoteException{
		// TODO Auto-generated method stub
		return taiKhoanDAO.updateTaiKhoan(taiKhoan);
	}

	@Override
	public boolean addTaiKhoan(TaiKhoan taiKhoan) throws RemoteException {
		// TODO Auto-generated method stub
		return taiKhoanDAO.addTaiKhoan(taiKhoan);
	}

}
