package model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
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
	private int idS;
	private String username;
	private String password;
	private boolean typeA;		
	public Account() {

	}
	public Account(int idS, String username, String password, boolean typeA) {
		this.idS = idS;
		this.username = username;
		this.password = password;
		this.typeA = typeA;
	}
	public int getIdS() {
		return idS;
	}
	public void setIdS(int idS) {
		this.idS = idS;
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
	public boolean isTypeA() {
		return typeA;
	}
	public void setTypeA(boolean typeA) {
		this.typeA = typeA;
	}
	
	
}
