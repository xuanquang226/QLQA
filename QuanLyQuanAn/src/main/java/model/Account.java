package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name="Account")
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private Boolean typeA;
	
	@ManyToMany(mappedBy = "lAccount", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> lRole = new ArrayList<Role>();
	public Account() {

	}
	public Account(long id, String username, String password, Boolean typeA) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.typeA = typeA;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean isTypeA() {
		return typeA;
	}
	public void setTypeA(Boolean typeA) {
		this.typeA = typeA;
	}
	public List<Role> getlRole() {
		return lRole;
	}
	public void setlRole(List<Role> lRole) {
		this.lRole = lRole;
	}
	
	
	
}
