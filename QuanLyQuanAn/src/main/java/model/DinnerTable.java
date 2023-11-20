package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Entity(name ="DinnerTable")
@Table(name= "dinnertable")
public class DinnerTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "stt")
	@Nullable
	private boolean stt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dinnerTable")
	private List<Order> order;
	
	@Column(name = "id_order")
	private long idOrder;
	
	
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
	
	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
	
	public long getIdOrder() {
		return idOrder;
	}
	
}
