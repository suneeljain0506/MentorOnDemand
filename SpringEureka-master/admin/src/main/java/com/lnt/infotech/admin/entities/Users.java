package com.lnt.infotech.admin.entities;

import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Users {
	@Id
	private String email;
	private String userName;
	private String password;
	private String status;
	private String role;
	private String phone;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_trainings", joinColumns = {
			@JoinColumn(referencedColumnName = "email") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id") })
	private Set<Trainings> trainings;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_email")
	private Set<Payments> payments;

	@OneToOne
	@JoinColumn(name = "mentor_id")
	private TrainerDetails trainerDetails;
//	(mappedBy="user")	
//	(cascade = CascadeType.ALL)	
	
	@ManyToMany
	private Set<Skills> skills;

	public Users() {

	}
	
	

	public Set<Skills> getSkills() {
		return skills;
	}



	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}



	public Users(String email, String userName, String password, String status, String role, String phone,
			Set<Trainings> trainings, Set<Payments> payments) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.role = role;
		this.trainings = trainings;
		this.payments = payments;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TrainerDetails getTrainerDetails() {
		return trainerDetails;
	}

	public void setTrainerDetails(TrainerDetails trainerDetails) {
		this.trainerDetails = trainerDetails;
	}

	public Set<Payments> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payments> payments) {
		this.payments = payments;
	}

	public Set<Trainings> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Trainings> trainings) {
		this.trainings = trainings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String userMail) {
		this.email = userMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	@Embedded
////	private Address address;

//	
//	public Address getAddress() {
//		return address;
//	}
//
//
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	// ,Address address
//	

}
