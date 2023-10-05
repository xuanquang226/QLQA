package model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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


@Entity
@Component

public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStaff;
	
	@Column(name = "name_staff")
	private String nameStaff;
	
	@Column(name = "working_hours")
	private float workingHours;
	
	@Column(name = "ohour_salary")
	private float oHourSalary;
	
	@Column(name = "position")
	private String position;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private List<Order> order;
	
	@OneToOne
	@JoinColumn(name = "id_account")
	private Account account;
	
	public Staff() {}

	public Staff(long idStaff, String nameStaff, float workingHours, float oHourSalary, String position, Account account) {
		this.idStaff = idStaff;
		this.nameStaff = nameStaff;
		this.workingHours = workingHours;
		this.oHourSalary = oHourSalary;
		this.position = position;
		this.account = account;
	}

	public long getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(long idStaff) {
		this.idStaff = idStaff;
	}

	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public float getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(float workingHours) {
		this.workingHours = workingHours;
	}

	public float getoHourSalary() {
		return oHourSalary;
	}

	public void setoHourSalary(float oHourSalary) {
		this.oHourSalary = oHourSalary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Order> getOrder() {
		return order;
	}
	
}
