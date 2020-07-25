package com.lnt.infotech.admin.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToOne;

@Entity
public class MentorSkills {

	@Id
	private int id;
	private String name;
	private String toc;
	private String prerequisites;
	
	

	public MentorSkills() {
//		super();
	}

	public MentorSkills(int id, String name, String toc, String prerequisites) {
		super();
		this.id = id;
		this.name = name;
		this.toc = toc;
		this.prerequisites = prerequisites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToc() {
		return toc;
	}

	public void setToc(String toc) {
		this.toc = toc;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

}
