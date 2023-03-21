package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import bus.PhanLoaiService;
import entity.PhanLoai;
import gui.FrmLogin;
import gui.Frm_QuanLyThuocTinh;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		int port = 6273;
		String host = "Kris-sLaptop";
		FrmLogin frm_Login = new FrmLogin(port,host);
		frm_Login.setVisible(true);
	}
}
	