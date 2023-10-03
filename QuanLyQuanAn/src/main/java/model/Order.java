package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="orderD")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrder;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_dish", joinColumns = {@JoinColumn(name="id_order")}, inverseJoinColumns = {@JoinColumn(name="id_dish")})
	private Set<Dish> listMonAn = new HashSet<Dish>();
	
	@ManyToOne
	@JoinColumn(name="dinner_table")
	private DinnerTable dinnerTable;
	
	@ManyToOne
	@JoinColumn(name="staff")
	private Staff staff;
	
	private Date date;
	
	private boolean state;
	
	public Order() {
		
	}

	public Order(long idOrder, Set<Dish> listMonAn, DinnerTable dinnerTable, Staff staff, Date date, boolean state) {
		this.idOrder = idOrder;
		this.listMonAn = listMonAn;
		this.dinnerTable = dinnerTable;
		this.staff = staff;
		this.date = date;
		this.state = state;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return idOrder;
	}


	public void setId(int idOrder) {
		this.idOrder = idOrder;
	}


	public Set<Dish> getListMonAn() {
		return listMonAn;
	}


	public void setListMonAn(Set<Dish> listMonAn) {
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


	public void setMonAn(Dish dish) {
		this.listMonAn.add(dish);
	}
}
