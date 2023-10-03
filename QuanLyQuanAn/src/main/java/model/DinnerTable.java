package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name ="DinnerTable")
@jakarta.persistence.Table(name= "dinnertable")
@Component
public class DinnerTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oNumber;
	private boolean stt;
	
	@OneToMany(mappedBy = "dinnerTable")
	private Set<Order> order;
	
	public DinnerTable() {

	}

	public DinnerTable(int oNumber, boolean stt) {
		this.oNumber = oNumber;
		this.stt = stt;
	}
	
	public int getoNumber() {
		return oNumber;
	}

	public void setoNumber(int oNumber) {
		this.oNumber = oNumber;
	}

	public boolean isStt() {
		return stt;
	}

	public void setStt(boolean stt) {
		this.stt = stt;
	}
	
	public Set<Order> getOrder() {
		return order;
	}
}
