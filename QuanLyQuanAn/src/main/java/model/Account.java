package model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Account")
@Table(name="account")
@Component
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idA;
	private String username;
	private String password;
	private Boolean typeA;
	
	public Account() {}
	
	
	
	public Account(int idA, String username, String password, Boolean typeA) {
		this.idA = idA;
		this.username = username;
		this.password = password;
		this.typeA = typeA;
	}
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
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
	public Boolean getTypeA() {
		return typeA;
	}
	public void setTypeA(Boolean typeA) {
		this.typeA = typeA;
	}
	
	
}
