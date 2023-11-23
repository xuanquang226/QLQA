package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;
import org.springframework.stereotype.Component;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Data
@Entity(name ="DinnerTable")
@Table(name= "dinnertable")
public class DinnerTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 1)
	private boolean stt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dinnerTable")
	private List<Order> order;
	
	@Column(name = "id_order")
	private long idOrder;

	
}
