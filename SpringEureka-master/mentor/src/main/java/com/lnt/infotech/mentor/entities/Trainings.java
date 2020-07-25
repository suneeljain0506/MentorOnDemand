package com.lnt.infotech.mentor.entities;

//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Trainings {

	@Id
	private String id;
	private String status;
	private int progress;

	@OneToOne
	@JoinColumn(name="technologies_id")
	private Technologies technologies;

//	@ManyToMany(mappedBy = "trainings")
//	private Set<Users> users;

	
	public Trainings() {
//		super();
	}



	public Trainings(String id, String status, int progress, Technologies technologies) {
		super();
		this.id = id;
		this.status = status;
		this.progress = progress;
		this.technologies = technologies;
//		this.users = users; 
		//,Set<Users> users
	}
	
	

//	public Set<Users> getUsers() {
//		return users;
//	}
//
//
//
//	public void setUsers(Set<Users> users) {
//		this.users = users;
//	}



	public Technologies getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Technologies technologies) {
		this.technologies = technologies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

}
