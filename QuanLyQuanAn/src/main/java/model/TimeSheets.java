package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp dateTimeKeeping;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "timesheet_staff", joinColumns = {@JoinColumn(name = "id_timesheet")}, inverseJoinColumns = {@JoinColumn(name = "id_staff")})
	private Set<Staff> setStaff = new HashSet<Staff>();
	
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

}
