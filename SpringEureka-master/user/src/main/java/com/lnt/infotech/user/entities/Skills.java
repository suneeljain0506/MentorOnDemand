package com.lnt.infotech.user.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skills {

	public Skills() {

	}
	public Skills(String skill) {
		this.skill = skill;
	}

	@Id
	private String skill;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	
}
