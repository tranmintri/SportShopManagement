package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.NhaCungCapService;
import dao.NhaCungCapDAO;
import entity.NhaCungCap;

public class NhaCungCapService_Imp extends UnicastRemoteObject implements NhaCungCapService {

	private NhaCungCapDAO nhaCungCapDAO;

	public NhaCungCapService_Imp() throws RemoteException{
		nhaCungCapDAO = new NhaCungCapDAO();
	}

	@Override
	public List<NhaCungCap> getAllNhaCungCap() throws RemoteException{
		// TODO Auto-generated method stub
		return nhaCungCapDAO.getAllNhaCungCap();
	}

	@Override
	public boolean addNhaCungCap(NhaCungCap nhaCungCap) throws RemoteException{
		if (nhaCungCap.getTenNCC().toString().trim().isEmpty() || nhaCungCap.getTenNCC().toString().trim().isEmpty()
				|| nhaCungCap.getEmail().toString().trim().isEmpty()
				|| nhaCungCap.getDiaChi().toString().trim().isEmpty()
				|| nhaCungCap.getsDT().toString().trim().isEmpty())
			return false;
		return nhaCungCapDAO.addNhaCungCap(nhaCungCap);
	}

	@Override
	public NhaCungCap getNhaCungCapByName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return nhaCungCapDAO.getNhaCungCapByName(name);
	}

}
