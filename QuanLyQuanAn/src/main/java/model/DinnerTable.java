package model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name ="DinnerTable")
@jakarta.persistence.Table(name= "dinnertable")
@Component
public class DinnerTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oNumber;
	private boolean stt;
	
	public DinnerTable() {

	}

	public DinnerTable(int oNumber, boolean stt) {
		this.oNumber = oNumber;
		this.stt = stt;
	}
	
	public int getoNumber() {
		return oNumber;
	}

	public void setoNumber(int oNumber) {
		this.oNumber = oNumber;
	}

	public boolean isStt() {
		return stt;
	}

	public void setStt(boolean stt) {
		this.stt = stt;
	}
	
}
