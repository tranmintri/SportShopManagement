package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDon;

public interface ChiTietHoaDonService extends Remote {
	public boolean addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
	public List<ChiTietHoaDon> getChiTietHoaDonByIDHoaDon(String maHD) throws RemoteException;
	public List<Object[]> getThongKeDoanhThuVaSoLuongByMonthYear(int month, int year) throws RemoteException;
}
