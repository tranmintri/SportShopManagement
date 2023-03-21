package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDon;

public interface HoaDonService extends Remote{

	
	public List<HoaDon> getAllHoaDon() throws RemoteException;
	public boolean addHoaDon(HoaDon hoaDon) throws RemoteException;
}
