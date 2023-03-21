package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHangService extends Remote{
	public boolean addKhachHang(KhachHang kh) throws RemoteException;
	public List<KhachHang> getAllKhachHang() throws RemoteException;
	public KhachHang getKhachHangByID(String maKH) throws RemoteException;
	public List<KhachHang> getKhachHangByName(String hoVaTen) throws RemoteException;
	public List<KhachHang> getKhachHangBySDT(String SDT) throws RemoteException;
	public KhachHang getKhachHangBySDTSingle(String SDT) throws RemoteException;
	public KhachHang getKhachhangByEmail(String email) throws RemoteException;
	public List<KhachHang> getKhachHangByIdNameEmailSDT(String maKH, String hoVaTen, String email, String SDT) throws RemoteException;
	public void updateKhachHang(KhachHang kh) throws RemoteException;
}
