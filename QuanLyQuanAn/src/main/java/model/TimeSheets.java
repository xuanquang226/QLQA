package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "timesheets")
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")

public class TimeSheets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date_timekeeping")
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Jakarta")
	private Timestamp dateTimeKeeping;
	
	@JsonIgnore
	@OneToMany(mappedBy = "timeSheets", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<TimeSheetsStaff> setTimeSheetsStaff;
	
	public TimeSheets() {}

	public TimeSheets(long id, Timestamp dateTimeKeeping) {
		this.id = id;
		this.dateTimeKeeping = dateTimeKeeping;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDateTimeKeeping() {
		return dateTimeKeeping;
	}

	public void setDateTimeKeeping(Timestamp dateTimeKeeping) {
		this.dateTimeKeeping = dateTimeKeeping;
	}

	public Set<TimeSheetsStaff> getSetTimeSheetsStaff() {
		return setTimeSheetsStaff;
	}

	public void setSetTimeSheetsStaff(Set<TimeSheetsStaff> setTimeSheetsStaff) {
		this.setTimeSheetsStaff = setTimeSheetsStaff;
	}
	
	

}
