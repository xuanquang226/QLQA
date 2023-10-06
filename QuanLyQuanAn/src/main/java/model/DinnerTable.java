package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToOne;

@Entity(name ="DinnerTable")
@jakarta.persistence.Table(name= "dinnertable")
@Component

public class DinnerTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean stt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dinnerTable")
	private List<Order> order;
	
	
	public DinnerTable() {}
	
	public DinnerTable(long id, boolean stt) {
		this.id = id;
		this.stt = stt;
	}

	public long getID() {
		return id;
	}

	public void setoNumber(long id) {
		this.id = id;
	}

	public boolean isStt() {
		return stt;
	}

	public void setStt(boolean stt) {
		this.stt = stt;
	}
	
	
	
}
