package model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.id.factory.spi.GenerationTypeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name="Dish")
@Table(name = "dish")
@Component
@Scope("prototype")
public class Dish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int quantity;
	private Boolean state;
	private double price;
	
	@ManyToMany(mappedBy = "listMonAn")
	private Set<Order> listOrder = new HashSet<Order>();
	
	public Dish() {}
	
	public Dish(long id, String name, int quantity, Boolean state, double price) {
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

	
	public void setPrice(double d) {
		this.price = d;
	}
	
	public void setIdOrder(Order o) {
		listOrder.add(o);
	}
}
