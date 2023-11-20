package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name="orderr")
@JsonIdentityInfo(generator=ObjectIdGenerators.None.class, property="id")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	@JoinTable(name="order_dish", joinColumns = {@JoinColumn(name = "id_order")}, inverseJoinColumns = {@JoinColumn(name = "id_dish_order")})
	private Set<DishOrder> listMonAn = new HashSet<DishOrder>();
	

	@ManyToOne
	@JoinColumn(name="dinner_table")
	private DinnerTable dinnerTable;
	

	@ManyToOne
	@JoinColumn(name="staff")
	private Staff staff;
	
	@Column(name = "date_create")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Jakarta")
	private Timestamp dateCreate;
	
	@Column(name = "state")
	@Nullable
	private boolean state;
	
	@Column(name= "total_price")
	private double totalPrice;
	
	public Order() {
		
	}

	public Order(long id, DinnerTable dinnerTable, Staff staff, Timestamp date_create, boolean state) {
		this.id = id;
		this.dinnerTable = dinnerTable;
		this.staff = staff;
		this.dateCreate = date_create;
		this.state = state;
	}


	public Timestamp getDate() {
		return dateCreate;
	}

	public void setDate(Timestamp date_create) {
		this.dateCreate = date_create;
	}

	public long getId() {
		return id;
	}


	public void setId(int idOrder) {
		this.id = idOrder;
	}


	public Set<DishOrder> getListMonAn() {
		return listMonAn;
	}


	public void setListMonAn(Set<DishOrder> listMonAn) {
		this.listMonAn = listMonAn;
	}


	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}


	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public void setMonAn(DishOrder dishOrder) {
		this.listMonAn.add(dishOrder);
	}

	public void setTotalPrice(double totalPrice){
	    this.totalPrice = totalPrice;
	}

	public double getTotalPrice(){
	    return totalPrice;
	}
}
