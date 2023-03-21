package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhaCungCap;

public interface NhaCungCapService extends Remote{
	public List<NhaCungCap> getAllNhaCungCap() throws RemoteException;
	public boolean addNhaCungCap(NhaCungCap nhaCungCap) throws RemoteException;
	public NhaCungCap getNhaCungCapByName(String name) throws RemoteException;
}
