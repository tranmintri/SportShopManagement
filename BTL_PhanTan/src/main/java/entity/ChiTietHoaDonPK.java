package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4726121831025194139L;
	/**
	 * 
	 */

	private String sanPham;
	private String hoaDon;

	public ChiTietHoaDonPK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoaDon, sanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonPK other = (ChiTietHoaDonPK) obj;
		return Objects.equals(hoaDon, other.hoaDon) && Objects.equals(sanPham, other.sanPham);
	}

}
