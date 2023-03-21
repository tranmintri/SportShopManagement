package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.ChiTietHoaDonService;
import dao.ChiTietHoaDonDAO;
import entity.ChiTietHoaDon;

public class ChiTietHoaDonService_Imp extends UnicastRemoteObject implements ChiTietHoaDonService{
	private ChiTietHoaDonDAO chiTietHoaDon_DAO;
	public ChiTietHoaDonService_Imp() throws RemoteException{

		chiTietHoaDon_DAO = new ChiTietHoaDonDAO();
	}
	@Override
	public boolean addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException{
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.addChiTietHoaDon(chiTietHoaDon);
	}
	@Override
	public List<ChiTietHoaDon> getChiTietHoaDonByIDHoaDon(String maHD) throws RemoteException {
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.getChiTietHoaDonByIDHoaDon(maHD);
	}
	@Override
	public List<Object[]> getThongKeDoanhThuVaSoLuongByMonthYear(int month, int year) throws RemoteException {
		// TODO Auto-generated method stub
		return chiTietHoaDon_DAO.getThongKeDoanhThuVaSoLuongByMonthYear(month, year);
	}

}
