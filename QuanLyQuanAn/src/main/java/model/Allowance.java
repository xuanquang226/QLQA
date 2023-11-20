package model;

import org.springframework.stereotype.Component;


public class Allowance {
	private double overTimeCost;
	
	public Allowance() {}
	
	public Allowance(double overTimeCost) {
		this.overTimeCost = overTimeCost;
	}
	
	public void setOverTimeCost(double overTimeCost) {
		this.overTimeCost = overTimeCost;
	}
	
	public double getOverTimeCost() {
		return overTimeCost;
	}
}
