package com.lnt.infotech.admin;

import com.lnt.infotech.admin.entities.Skills;
import com.lnt.infotech.admin.entities.Technologies;
import com.lnt.infotech.admin.entities.TrainerDetails;
import com.lnt.infotech.admin.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//import java.util.Arrays;

@Service
public class TechnologiesService {

    @Autowired
    private UserRepository ur;
    @Autowired
    private TrainerDetailsRepository tdr;
    @Autowired
    private SkillsRepository skr;
    @Autowired
    private TechnologiesRepository techr;

    public ArrayList<Technologies> getTechList() {
        ArrayList<Technologies> technologiesList = new ArrayList<Technologies>();
        techr.findAll().forEach(technologiesList::add);
        return technologiesList;
    }

    public ArrayList<MentorSignUpModel> getUserList() {

        ArrayList<Users> userList = new ArrayList<Users>();
        ur.findAll().forEach(userList::add);
//		System.out.println("get request"+userList);

        ArrayList<MentorSignUpModel> formattedList = new ArrayList<MentorSignUpModel>();
        for(Users t: userList) {
            Set<String> stringSkills = new HashSet<String>();
            MentorSignUpModel m = new MentorSignUpModel();
//			TrainerDetails trainerDetails = new TrainerDetails();
            m.setEmail(t.getEmail());
            m.setEnddate(t.getTrainerDetails().getEnddate());
            m.setBlogs(t.getTrainerDetails().getBlogs());
            m.setDemos(t.getTrainerDetails().getDemos());
            m.setExperience(t.getTrainerDetails().getExperience());
            m.setLinkedin(t.getTrainerDetails().getLinkedin());
            m.setPassword(t.getPassword());
            m.setPhone(t.getPhone());
            m.setPpts(t.getTrainerDetails().getPpts());
            m.setRole(t.getRole());
            m.setStartdate(t.getTrainerDetails().getStartdate());
            m.setStatus(t.getStatus());
            m.setTimeslot(t.getTrainerDetails().getTimeslot());
            m.setTimezone(t.getTrainerDetails().getTimezone());
            m.setUserName(t.getUserName());
            m.setVideos(t.getTrainerDetails().getVideos());
            for(Skills temp: t.getSkills()) {
//				System.out.println(t.getSkill());
                stringSkills.add(temp.getSkill());
            }
            m.setSkills(stringSkills);
            formattedList.add(m);
        }

//		return userList;
        return formattedList;


    }

    public Users getUser(String id) {

        return ur.findById(id).orElse(null);
    }

    //	public void setUserList(ArrayList<UserDetails> userList) {
//		this.userList = userList;
//	}
//
    public void addUserDetails(MentorSignUpModel s) {
        Users user = new Users();
        TrainerDetails trainerDetails = new TrainerDetails();
//		Skills skills = new Skills();
//		skills.setSkill(s.getSkills());
//		List<Skills> skills = s.getSkills();
//		skr.save(skills);
        Set<Skills> skills = new HashSet<Skills>();
        for(String skillString : s.getSkills()){
            Skills skill = new Skills();
            skill.setSkill(skillString);
            skills.add(skill);

        }
        for(Skills t: skills) {
            System.out.println(t.getSkill());
        }

        trainerDetails.setEmail(s.getEmail());
        trainerDetails.setBlogs(s.isBlogs());
        trainerDetails.setDemos(s.isDemos());
        trainerDetails.setExperience(s.getExperience());
        trainerDetails.setLinkedin(s.getLinkedin());
        trainerDetails.setPpts(s.isPpts());
        trainerDetails.setTimeslot(s.getTimeslot());
        trainerDetails.setTimezone(s.getTimezone());
        trainerDetails.setVideos(s.isVideos());
        trainerDetails.setStartdate(s.getStartdate());
        trainerDetails.setEnddate(s.getEnddate());
        tdr.save(trainerDetails);
        user.setEmail(s.getEmail());
        user.setPassword(s.getPassword());
        user.setPhone(s.getPhone());
        user.setRole(s.getRole());
        user.setStatus(s.getStatus());
        user.setTrainerDetails(trainerDetails);
        user.setUserName(s.getUserName());
        user.setSkills(skills);

        ur.save(user);
    }

    //
//
    public void updateUser(Users s, String id) {


        ur.save(s);

    }

    public void addTechnology(Technologies tech) {
        techr.save(tech);
    }

    //
    public void deleteUser(String id) {
        ur.deleteById(id);
    }
    public void deleteTech(String id) {
        techr.deleteById(id);
    }

}