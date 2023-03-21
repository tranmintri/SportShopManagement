package busImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import bus.ChatLieuService;
import dao.ChatLieuDAO;
import entity.ChatLieu;

public class ChatLieuService_Imp extends UnicastRemoteObject  implements ChatLieuService{
	/**
	 * 
	 */
	private ChatLieuDAO chatLieuDAO;

	public ChatLieuService_Imp() throws RemoteException{

		chatLieuDAO = new ChatLieuDAO();
		
	}
	@Override
	public boolean addChatLieu(ChatLieu chatLieu) throws RemoteException{
		// TODO Auto-generated method stub
		if(chatLieu.getMaChatLieu().toString().trim().isEmpty())
			return false;
		return chatLieuDAO.addChatLieu(chatLieu);
	}

	@Override
	public ChatLieu findChatLieuById(String id) throws RemoteException{
		return chatLieuDAO.findChatLieuById(id);
	}

	@Override
	public boolean updateChatLieu(ChatLieu chatLieu) throws RemoteException{
		// TODO Auto-generated method stub
		return chatLieuDAO.updateChatLieu(chatLieu);
	}
	@Override
	public List<ChatLieu> getAllChatLieu() throws RemoteException{
		// TODO Auto-generated method stub
		return chatLieuDAO.getAllChatLieu();
	}
	@Override
	public ChatLieu findChatLieuByName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return chatLieuDAO.findChatLieuByName(name);
	}

}
