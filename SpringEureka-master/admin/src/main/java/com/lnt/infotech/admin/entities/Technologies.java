package com.lnt.infotech.admin.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Technologies {
	
	@Id
	private String technology;
	private int fee;
	private int commission;
	
//	@OneToOne(mappedBy="technologies")
//	private Trainings trainings;
//
	
	
	public Technologies() {
//		super();
	}

	public Technologies(String technology, int fee, int commission) {
		this.technology = technology;
		this.fee = fee;
		this.commission = commission;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}
}
