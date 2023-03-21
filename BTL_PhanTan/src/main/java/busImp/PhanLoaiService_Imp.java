package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.PhanLoaiService;
import dao.PhanLoaiDAO;
import entity.PhanLoai;

public class PhanLoaiService_Imp extends UnicastRemoteObject implements PhanLoaiService {
	private PhanLoaiDAO phanLoaiDAO;

	public PhanLoaiService_Imp() throws RemoteException{

		phanLoaiDAO = new PhanLoaiDAO();
		
	}

	@Override
	public boolean addPhanLoai(PhanLoai phanLoai) throws RemoteException{
		if (phanLoai.getMaPhanLoai().toString().trim().isEmpty())
			return false;
		return phanLoaiDAO.addPhanLoai(phanLoai);
	}

	@Override
	public PhanLoai findPhanLoaiById(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return phanLoaiDAO.findPhanLoaiById(id);
	}

	@Override
	public boolean updatePhanLoai(PhanLoai phanLoai) throws RemoteException{
		// TODO Auto-generated method stub
		return phanLoaiDAO.updatePhanLoai(phanLoai);
	}

	@Override
	public List<PhanLoai> getAllPhanLoai() throws RemoteException{
		// TODO Auto-generated method stub
		return phanLoaiDAO.getAllPhanLoai();
	}

	@Override
	public PhanLoai getPhanLoaiByName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return phanLoaiDAO.getPhanLoaiByName(name);
	}

}
