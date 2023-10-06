package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Component
@Table(name="orderr")
@JsonIdentityInfo(generator=ObjectIdGenerators.None.class, property="id")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="order_dish", joinColumns = {@JoinColumn(name = "id_order")}, inverseJoinColumns = {@JoinColumn(name = "id_dish_order")})
	private Set<DishOrder> listMonAn = new HashSet<DishOrder>();
	
	@ManyToOne
	@JoinColumn(name="dinner_table")
	private DinnerTable dinnerTable;
	
	@ManyToOne
	@JoinColumn(name="staff")
	private Staff staff;
	
	private Date date;
	
	private boolean state;
	
	private String note;
	
	public Order() {
		
	}

	public Order(long id, DinnerTable dinnerTable, Staff staff, Date date, boolean state, String note) {
		this.id = id;
		this.dinnerTable = dinnerTable;
		this.staff = staff;
		this.date = date;
		this.state = state;
		this.note = note;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
