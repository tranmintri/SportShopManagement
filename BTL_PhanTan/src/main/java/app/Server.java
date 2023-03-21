package app;

import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import bus.ChatLieuService;
import bus.ChiTietHoaDonService;
import bus.HoaDonService;
import bus.KhachHangService;
import bus.MauSacService;
import bus.NhaCungCapService;
import bus.NhanVienService;
import bus.PhanLoaiService;
import bus.SanPhamService;
import bus.TaiKhoanService;
import bus.XuatXuService;
import busImp.ChatLieuService_Imp;
import busImp.ChiTietHoaDonService_Imp;
import busImp.HoaDonService_Imp;
import busImp.KhachHangService_Imp;
import busImp.MauSacService_Imp;
import busImp.NhaCungCapService_Imp;
import busImp.NhanVienService_Imp;
import busImp.PhanLoaiService_Imp;
import busImp.SanPhamService_Imp;
import busImp.TaiKhoanService_Imp;
import busImp.XuatXuService_Imp;
import entity.NhaCungCap;


public class Server {
	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("removal")
		SecurityManager securityManager = new SecurityManager();
		if(securityManager == null) {
			System.getProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		
		
		Context context = new InitialContext();
		int port = 6273;
		String host = "Kris-sLaptop";
		LocateRegistry.createRegistry(port);
		
		PhanLoaiService phanLoaiService = new PhanLoaiService_Imp();
		context.bind("rmi://"+host+":"+port+"/phanLoaiService", phanLoaiService);
		
		ChatLieuService chatLieuService = new ChatLieuService_Imp();
		context.bind("rmi://"+host+":"+port+"/chatLieuService", chatLieuService);
		
		MauSacService mauSacService = new MauSacService_Imp();
		context.bind("rmi://"+host+":"+port+"/mauSacService", mauSacService);
		
		NhaCungCapService nhaCungCapService = new NhaCungCapService_Imp();
		context.bind("rmi://"+host+":"+port+"/nhaCungCapService", nhaCungCapService);
		
		XuatXuService xuatXuService = new XuatXuService_Imp();
		context.bind("rmi://"+host+":"+port+"/xuatXuService", xuatXuService);
		
		ChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonService_Imp();
		context.bind("rmi://"+host+":"+port+"/chiTietHoaDonService", chiTietHoaDonService);
		
		HoaDonService hoaDonService = new HoaDonService_Imp();
		context.bind("rmi://"+host+":"+port+"/hoaDonService", hoaDonService);
		
		KhachHangService khachHangService = new KhachHangService_Imp();
		context.bind("rmi://"+host+":"+port+"/khachHangService", khachHangService);
		
		NhanVienService nhanVienService = new NhanVienService_Imp();
		context.bind("rmi://"+host+":"+port+"/nhanVienService", nhanVienService);
		
		SanPhamService sanPhamService = new SanPhamService_Imp();
		context.bind("rmi://"+host+":"+port+"/sanPhamService", sanPhamService);
		
		TaiKhoanService taiKhoanService = new TaiKhoanService_Imp();
		context.bind("rmi://"+host+":"+port+"/taiKhoanService", taiKhoanService);
		
		System.out.println("Bound");
	}
}
