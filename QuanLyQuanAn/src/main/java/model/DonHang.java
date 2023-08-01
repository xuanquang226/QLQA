package model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Component
public class DonHang {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idDH;
	private ArrayList<MonAn> monAns;
	private KhachHang kh;
	
	
	public DonHang() {
		
	}
	
	public DonHang(long iDH, ArrayList<MonAn> monAns, KhachHang kh) {
		this.idDH = idDH;
		this.monAns = monAns;
		this.kh = kh;
	}

	public long getIdDH() {
		return idDH;
	}

	public void setIdDH(long idDH) {
		this.idDH = idDH;
	}

	public ArrayList<MonAn> getMonAns() {
		return monAns;
	}

	public void setMonAns(ArrayList<MonAn> monAns) {
		this.monAns = monAns;
	}

	public KhachHang getKh() {
		return kh;
	}

	@Autowired
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	
	
}
