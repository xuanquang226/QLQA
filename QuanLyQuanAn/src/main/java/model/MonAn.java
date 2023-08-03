package model;

import org.hibernate.id.factory.spi.GenerationTypeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MonAn")
@Component
@Scope("prototype")
public class MonAn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int quantity;
	private Boolean state;
	private float price;
	
	public MonAn() {}
	
	public MonAn(String name) {
		this.name = name;
	}
	
	public MonAn(long id, String name, int quantity, Boolean state, float price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.state = state;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean getState() {
		return state;
	}


	public void setState(Boolean state) {
		this.state = state;
	}

	public double getPrice() {
		return price;
	}

	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
