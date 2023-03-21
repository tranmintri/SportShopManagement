package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TaiKhoan;

public interface TaiKhoanService extends Remote{
	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException;
	public boolean updateTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;
	public boolean addTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;
}
