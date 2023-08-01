package model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Entity
@Component
public class KhachHang {
	private long idKH;
	private String name;
//	private HoaDonThanhToan hdtt;
	
	public KhachHang() {
		
	}
	
	public KhachHang(long id, String name) {
		this.idKH = id;
		this.name = name;
	}

	public long getIdKH() {
		return idKH;
	}

	public void setIdKH(long idKH) {
		this.idKH = idKH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
