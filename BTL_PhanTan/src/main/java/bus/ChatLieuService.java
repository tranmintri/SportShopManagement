package bus;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import busImp.ChatLieuService_Imp;
import entity.ChatLieu;

public interface ChatLieuService extends Remote{
	public boolean addChatLieu(ChatLieu chatLieu) throws RemoteException;

	public ChatLieu findChatLieuById(String id) throws RemoteException;
	public ChatLieu findChatLieuByName(String name) throws RemoteException;
	public boolean updateChatLieu(ChatLieu chatLieu) throws RemoteException;
	public List<ChatLieu> getAllChatLieu() throws RemoteException;
}

