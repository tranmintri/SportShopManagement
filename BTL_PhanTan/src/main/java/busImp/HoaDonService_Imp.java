package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.HoaDonService;
import dao.HoaDonDAO;
import entity.HoaDon;

public class HoaDonService_Imp extends UnicastRemoteObject implements HoaDonService {

	private HoaDonDAO hoaDonDAO;

	public HoaDonService_Imp() throws RemoteException {

		hoaDonDAO = new HoaDonDAO();

	}

	@Override
	public List<HoaDon> getAllHoaDon() throws RemoteException {
		// TODO Auto-generated method stub
		return hoaDonDAO.getAllHoaDon();
	}

	@Override
	public boolean addHoaDon(HoaDon hoaDon) throws RemoteException {
		// TODO Auto-generated method stub
		return hoaDonDAO.addHoaDon(hoaDon);
	}

}
