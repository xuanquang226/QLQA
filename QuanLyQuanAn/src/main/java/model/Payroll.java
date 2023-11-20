package model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "payroll")
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")
public class Payroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@Autowired
//	@Column(name = "allowance")
//	private Allowance aw;
//	
//	@Autowired
//	@Column(name = "tax")
//	private Tax tax;
	
	
	
	@Column(name = "date_payroll")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = Shape.STRING, timezone = "Asia/Jakarta")
	private Timestamp dateCreatePayroll;
	
	@JsonIgnore
	@OneToMany(mappedBy = "payroll", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<PayrollStaff> setStaff;
	
	
	public Payroll() {}


//	public Payroll(long id, Allowance aw, Tax tax, double salary, String dateCreatePayroll) {
//		this.id = id;
//		this.aw = aw;
//		this.tax = tax;
//		this.salary = salary;
//		this.dateCreatePayroll = dateCreatePayroll;
//	}
	
	public Payroll(long id, Timestamp dateCreatePayroll) {
		this.id = id;
		this.dateCreatePayroll = dateCreatePayroll;
	}


	public long getId() {
		return id;
	}


//	public void setId(long id) {
//		this.id = id;
//	}
//
//
//	public Allowance getAw() {
//		return aw;
//	}
//
//
//	public void setAw(Allowance aw) {
//		this.aw = aw;
//	}
//
//
//	public Tax getTax() {
//		return tax;
//	}
//
//
//	public void setTax(Tax tax) {
//		this.tax = tax;
//	}



	public Timestamp getDateCreatePayroll() {
		return dateCreatePayroll;
	}


	public void setDateCreatePayroll(Timestamp dateCreatePayroll) {
		this.dateCreatePayroll = dateCreatePayroll;
	}


	public Set<PayrollStaff> getSetStaff() {
		return setStaff;
	}


	public void setSetStaff(Set<PayrollStaff> setStaff) {
		this.setStaff = setStaff;
	}
		
		
	
}
