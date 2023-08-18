package model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Entity
@Component
public class Guest {
	private int idKH;
	private String name;
	private String phone;
//	private HoaDonThanhToan hdtt;
	
	public Guest() {
		
	}
	
	public Guest(int id, String name, String phone) {
		this.idKH = id;
		this.name = name;
		this.phone = phone;
	}

	public long getIdKH() {
		return idKH;
	}

	public void setIdKH(int idKH) {
		this.idKH = idKH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
