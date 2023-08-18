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
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idDH;
	private ArrayList<Dish> monAns;
	private Guest kh;
	
	
	public Order() {
		
	}
	
	public Order(long iDH, ArrayList<Dish> monAns, Guest kh) {
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

	public ArrayList<Dish> getMonAns() {
		return monAns;
	}

	public void setMonAns(ArrayList<Dish> monAns) {
		this.monAns = monAns;
	}

	public Guest getKh() {
		return kh;
	}

	@Autowired
	public void setKh(Guest kh) {
		this.kh = kh;
	}
	
	
}
