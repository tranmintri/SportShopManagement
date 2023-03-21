package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.KhachHangService;
import dao.KhachHangDAO;
import entity.KhachHang;

public class KhachHangService_Imp extends UnicastRemoteObject implements KhachHangService {
	private KhachHangDAO khachhang_DAO;

	public KhachHangService_Imp() throws RemoteException {
		// TODO Auto-generated constructor stub
		khachhang_DAO = new KhachHangDAO();
	}

	@Override
	public boolean addKhachHang(KhachHang kh) throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.addKhachHang(kh);
	}

	@Override
	public List<KhachHang> getAllKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getAllKhachHang();
	}

	@Override
	public KhachHang getKhachHangByID(String maKH) throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getKhachHangById(maKH);
	}

	@Override
	public List<KhachHang> getKhachHangByName(String hoVaTen) throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getKhachHangByName(hoVaTen);
	}

	@Override
	public List<KhachHang> getKhachHangBySDT(String SDT) throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getKhachHangBySDT(SDT);
	}

	@Override
	public KhachHang getKhachhangByEmail(String email) throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getKhachHangByEmail(email);
	}

	@Override
	public List<KhachHang> getKhachHangByIdNameEmailSDT(String maKH, String hoVaTen, String email, String SDT)
			throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getKhachHangByIdNameEmailSDT(maKH, hoVaTen, email, SDT);
	}

	@Override
	public void updateKhachHang(KhachHang kh) throws RemoteException {
		// TODO Auto-generated method stub
		khachhang_DAO.updateKH(kh);
	}

	@Override
	public KhachHang getKhachHangBySDTSingle(String SDT) throws RemoteException {
		// TODO Auto-generated method stub
		return khachhang_DAO.getKhachHangBySDTSingle(SDT);
	}

}
