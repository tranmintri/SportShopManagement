package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.SanPham;

public interface SanPhamService extends Remote{
	public boolean addSanPham(SanPham sanPham) throws RemoteException;
	public SanPham findSanPhamById(String id) throws RemoteException;
	public boolean updateSanPham(SanPham sanPham) throws RemoteException;
	public List<SanPham> getAllSanPham() throws RemoteException;
}
