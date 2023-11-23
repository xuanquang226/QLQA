package model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.id.factory.spi.GenerationTypeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name="Dish")
@Table(name = "dish")
@JsonIdentityInfo(generator=ObjectIdGenerators.None.class, property="id")
public class Dish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int quantity;

	private double price;
	
	
	public Dish() {}
	
	public Dish(long id, String name, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;

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



	public double getPrice() {
		return price;
	}
}
