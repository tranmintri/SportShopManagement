package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;
import entity.NhanVien;

public interface NhanVienService extends Remote{
	public boolean addNhanVien(NhanVien nv) throws RemoteException;
	public List<NhanVien> getAllNhanVien() throws RemoteException;
	public NhanVien getNhanVienById(String maNV) throws RemoteException;
	public List<NhanVien> getNhanVienByName(String hoVaTen) throws RemoteException;
	public NhanVien getNhanVienByEmail(String email) throws RemoteException;
	public List<NhanVien> getNhanVienBySDT(String SDT) throws RemoteException;
	public List<NhanVien> getNhanVienByIdNameEmailSDT(String maNV, String hoVaTen, String email, String SDT) throws RemoteException;
	public void updateNhanVien(NhanVien nv) throws RemoteException;
	public List<NhanVien> getNhanByNameSDT(String hoVaTen, String SDT) throws RemoteException;
	
	
}
