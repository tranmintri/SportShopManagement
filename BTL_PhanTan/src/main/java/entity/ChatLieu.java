package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import busImp.ChatLieuService_Imp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 *
 * @author 20086
 */
@Entity
public class ChatLieu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3262941933463704473L;
	/**
	 * 
	 */
	@Id
	private String maChatLieu;
	@Column(columnDefinition = "nvarchar(255)")
	private String chatLieu;

	@OneToMany(mappedBy = "chatLieu")
	private List<SanPham> sanPham;

	public ChatLieu() {
	}

	public ChatLieu(String maChatLieu, String chatLieu) {
		this.maChatLieu = maChatLieu;
		this.chatLieu = chatLieu;
	}

	public String getMaChatLieu() {
		return maChatLieu;
	}

	public void setMaChatLieu(String maChatLieu) {
		this.maChatLieu = maChatLieu;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	@Override
	public String toString() {
		return "ChatLieu [maChatLieu=" + maChatLieu + ", chatLieu=" + chatLieu + "]";
	}
	
}
