package model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payrollstaff")
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")
public class PayrollStaff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Payroll payroll;
	
	@ManyToOne
	private Staff staff;
	
	private double salary;
	
	@Column(name = "count_workday")
	private int countWork;
	
	public PayrollStaff() {}

	public PayrollStaff(long id, double salary, int countWork) {
		this.id = id;
		this.salary = salary;
		this.countWork = countWork;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getCount() {
		return countWork;
	}

	public void setCount(int countWork) {
		this.countWork = countWork;
	}
	
	
}
