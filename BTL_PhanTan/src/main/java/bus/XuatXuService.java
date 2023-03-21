package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.XuatXu;

public interface XuatXuService extends Remote{
	public List<XuatXu> getAllXuatXu()throws RemoteException;

	public boolean addXuatXu(XuatXu xuatXu)throws RemoteException;

	public XuatXu getXuatXuByName(String name)throws RemoteException;
}
