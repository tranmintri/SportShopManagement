package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhanLoai;

public interface PhanLoaiService extends Remote{
	public boolean addPhanLoai(PhanLoai phanLoai) throws RemoteException;

	public PhanLoai findPhanLoaiById(String id) throws RemoteException;

	public boolean updatePhanLoai(PhanLoai phanLoai) throws RemoteException;
	
	public List<PhanLoai> getAllPhanLoai() throws RemoteException;
	public PhanLoai getPhanLoaiByName(String name) throws RemoteException;
}
