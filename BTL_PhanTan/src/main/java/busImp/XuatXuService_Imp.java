package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.XuatXuService;
import dao.XuatXuDAO;
import entity.XuatXu;

public class XuatXuService_Imp extends UnicastRemoteObject implements XuatXuService{
	private XuatXuDAO xuatXuDAO;
	public XuatXuService_Imp() throws RemoteException{
		xuatXuDAO = new XuatXuDAO();
	}
	@Override
	public List<XuatXu> getAllXuatXu() throws RemoteException{
		// TODO Auto-generated method stub
		return xuatXuDAO.getAllXuatXu();
	}
	@Override
	public boolean addXuatXu(XuatXu xuatXu) throws RemoteException{
		if (xuatXu.getNoiXuatXu().toString().trim().isEmpty())
			return false;
		return xuatXuDAO.addXuatXu(xuatXu);
	}
	@Override
	public XuatXu getXuatXuByName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return xuatXuDAO.getXuatXuByName(name);
	}
	
}
