package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.MauSacService;
import dao.MauSacDAO;
import entity.MauSac;

public class MauSacService_Imp extends UnicastRemoteObject implements MauSacService{

	private MauSacDAO mauSacDAO;
	
	public MauSacService_Imp() throws RemoteException{
		mauSacDAO = new MauSacDAO();
	}
	
	@Override
	public List<MauSac> getAllMauSac() throws RemoteException{
		// TODO Auto-generated method stub
		return mauSacDAO.getAllMauSac();
	}

	@Override
	public boolean addMauSac(MauSac mauSac) throws RemoteException{
		if(mauSac.getMauSac().toString().trim().isEmpty())
			return false;
		return mauSacDAO.addMauSac(mauSac);
	}

	@Override
	public MauSac getMauSacByName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return mauSacDAO.getMauSacByName(name);
	}

}
