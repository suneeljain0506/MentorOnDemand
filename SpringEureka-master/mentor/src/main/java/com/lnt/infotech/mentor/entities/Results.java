package com.lnt.infotech.mentor.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Results {
    @Id
    String userName;
    int experience;
    String email;

    public Results() {
    }

    public Results(String userName, int experience,String email) {
        this.userName = userName;
        this.experience = experience;
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
