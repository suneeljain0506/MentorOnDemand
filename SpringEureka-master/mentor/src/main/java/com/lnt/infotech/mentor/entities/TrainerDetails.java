package com.lnt.infotech.mentor.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class TrainerDetails {

	@Id
//	@GeneratedValue
	private String email;
//	@OneToOne
//	@JoinColumn(name = "trainerdetails_user")
//	private Users user;
	private int experience;
	private String timezone;
	private String timeslot;
	//private String materialType;
	private String linkedin;
	// private Set<String>skills;
	private boolean videos;
	private boolean blogs;
	private boolean ppts;
	private boolean demos;
	private Date startdate;
	private Date enddate;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerdetails_id")
	private Set<MentorSkills> mentorSkills;

	public TrainerDetails() {
//		super();
	}

//	public Set<String> getSkills() {
//		return skills;
//	}
//
//
//
//	public void setSkills(Set<String> skills) {
//		this.skills = skills;
//	}

//
//
//	public boolean isVideos() {
//		return videos;
//	}
//
//
//
//	public void setVideos(boolean videos) {
//		this.videos = videos;
//	}
//
//
//
//	public boolean isBlogs() {
//		return blogs;
//	}
//
//
//
//	public void setBlogs(boolean blogs) {
//		this.blogs = blogs;
//	}
//
//
//
//	public boolean isPpts() {
//		return ppts;
//	}
//
//
//
//	public void setPpts(boolean ppts) {
//		this.ppts = ppts;
//	}
//
//
//
//	public boolean isDemos() {
//		return demos;
//	}
//
//
//
//	public void setDemos(boolean demos) {
//		this.demos = demos;
//	}
	
	

	public boolean getVideos() {
		return videos;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setVideos(boolean videos) {
		this.videos = videos;
	}

	public boolean getBlogs() {
		return blogs;
	}

	public void setBlogs(boolean blogs) {
		this.blogs = blogs;
	}

	public boolean getPpts() {
		return ppts;
	}

	public void setPpts(boolean ppts) {
		this.ppts = ppts;
	}

	public boolean getDemos() {
		return demos;
	}

	public void setDemos(boolean demos) {
		this.demos = demos;
	}

	public TrainerDetails(Users user, int experience, String timeZone, String timeSlot, String materialType,
			String linkedinUrl, Set<MentorSkills> mentorSkills) {
		super();
		// this.user = user;
		this.experience = experience;
		this.timezone = timeZone;
		this.timeslot = timeSlot;
	//	this.materialType = materialType;
		this.linkedin = linkedinUrl;
		this.mentorSkills = mentorSkills;
	}

	public Set<MentorSkills> getMentorSkills() {
		return mentorSkills;
	}

	public void setMentorSkills(Set<MentorSkills> mentorSkills) {
		this.mentorSkills = mentorSkills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String id) {
		this.email = id;
	}

//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timeZone) {
		this.timezone = timeZone;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeSlot) {
		this.timeslot = timeSlot;
	}

//	public String getMaterialType() {
//		return materialType;
//	}
//
//	public void setMaterialType(String materialType) {
//		this.materialType = materialType;
//	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedinUrl) {
		this.linkedin = linkedinUrl;
	}

}
