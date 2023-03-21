package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.MauSac;

public interface MauSacService extends Remote{
	public List<MauSac> getAllMauSac() throws RemoteException;
	public boolean addMauSac(MauSac mauSac) throws RemoteException;
	public MauSac getMauSacByName(String name) throws RemoteException;
}
