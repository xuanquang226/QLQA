package model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "timesheetstaff")
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")
public class TimeSheetsStaff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_timesheets")
	private TimeSheets timeSheets;
	
	@ManyToOne
	@JoinColumn(name = "id_staff")
	private Staff stafff;
	
	@Column(name = "time_scan")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp timestamp;

	public TimeSheetsStaff(){}

	public TimeSheetsStaff(long id, TimeSheets timeSheets, Staff stafff, Timestamp timestamp) {
		this.id = id;
		this.timeSheets = timeSheets;
		this.stafff = stafff;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TimeSheets getTimeSheets() {
		return timeSheets;
	}

	public void setTimeSheets(TimeSheets timeSheets) {
		this.timeSheets = timeSheets;
	}

	public Staff getStaff() {
		return stafff;
	}

	public void setStaff(Staff stafff) {
		this.stafff = stafff;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
