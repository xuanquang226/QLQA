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
	@Column(name="id_account")
	private long idS;
	private String username;
	private String password;
	private Boolean typeA;		
	public Account() {

	}
	public Account(long idS, String username, String password, Boolean typeA) {
		this.idS = idS;
		this.username = username;
		this.password = password;
		this.typeA = typeA;
	}
	public long getIdS() {
		return idS;
	}
	public void setIdS(long idS) {
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
	public Boolean isTypeA() {
		return typeA;
	}
	public void setTypeA(Boolean typeA) {
		this.typeA = typeA;
	}
	
	
}
