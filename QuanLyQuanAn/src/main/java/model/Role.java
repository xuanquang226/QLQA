package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "role")
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "role_account", joinColumns = {@JoinColumn(name ="role_id")}, inverseJoinColumns = {@JoinColumn(name = "account_id")})
	private List<Account> lAccount = new ArrayList<Account>();

	public Role() {
	}

	public Role(long id, String name, List<Account> lAccount) {
		this.id = id;
		this.name = name;
		this.lAccount = lAccount;
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

	public List<Account> getlAccount() {
		return lAccount;
	}

	public void setlAccount(List<Account> lAccount) {
		this.lAccount = lAccount;
	}
	
	
}
