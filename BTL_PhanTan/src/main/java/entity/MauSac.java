/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import busImp.ChatLieuService_Imp;
import busImp.MauSacService_Imp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import dao.MauSacDAO;

/**
 *
 * @author 20086
 */
@Entity
public class MauSac implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -265665279570661551L;
	@Id
    private String maMauSac;
	@Column(columnDefinition = "nvarchar(255)")
    private String mauSac;

    @OneToMany(mappedBy = "mauSac")
    private List<SanPham> sanPham;
    
    public MauSac() {
    }
    

    public MauSac(String maMauSac, String mauSac) {
        this.maMauSac = maMauSac;
        this.mauSac = mauSac;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }


	@Override
	public String toString() {
		return "MauSac [maMauSac=" + maMauSac + ", mauSac=" + mauSac + "]";
	}
    
    
}
