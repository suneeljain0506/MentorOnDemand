package com.lnt.infotech.user.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SearchResult {
	
	@Id
	private String trainer;
	private String avatar;
	private Integer experience;
	private Integer rating;
	private Integer trainings;
	private Integer fee;
	
	
	
	public SearchResult() {
		super();
	}
	public SearchResult(String trainer, String avatar, Integer experience, Integer rating, Integer trainings,
			Integer fee) {
		super();
		this.trainer = trainer;
		this.avatar = avatar;
		this.experience = experience;
		this.rating = rating;
		this.trainings = trainings;
		this.fee = fee;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getTrainings() {
		return trainings;
	}
	public void setTrainings(Integer trainings) {
		this.trainings = trainings;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	
	

}
