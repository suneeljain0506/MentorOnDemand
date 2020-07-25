package com.lnt.infotech.mentor;

import java.util.ArrayList;
//import java.util.List;

import com.lnt.infotech.mentor.entities.Results;
import com.lnt.infotech.mentor.entities.SearchForm;
import com.lnt.infotech.mentor.entities.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.infotech.mentor.entities.Users;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResultsRepository resultsRepository;

//    @Autowired
//    TrainingsService trainingsService;
//
//    @Autowired
//    SearchService searchService;

    @RequestMapping("")
    public String hi() {
        return "Hi";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/mentors")
    public ArrayList<MentorSignUpModel> getList(){
        return userService.getUserList();
    }

    @RequestMapping("/skills")
    public ArrayList<Skills> getSkillList(){
        ArrayList<Skills> technologiesList = new ArrayList<Skills>();
        skillsRepository.findAll().forEach(technologiesList::add);
        return technologiesList;
//        return userService.getUserList();
    }

    @RequestMapping("/mentors/{id}")
    public Users getUserList(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping("/block/{id}")
    public void blockMentor(@PathVariable String id){
        Users user = userService.getUser(id);
        if(user.getStatus().equals("unblocked"))
            user.setStatus("blocked");
        else
            user.setStatus("unblocked");
        userService.updateUser(user,id);
    }

//    @RequestMapping("/trainings")
//    public ArrayList<Trainings> getTrainingList(){
//        return trainingsService.getTrainingsList();
//    }
//
//    @RequestMapping("/results")
//    public ArrayList<SearchResult> getResultList(){
//        return searchService.getResultList();
//    }
//
//    @RequestMapping(method=RequestMethod.POST,value = "/trainings")
//    public void addTrainings(@RequestBody Trainings s) {
//        trainingsService.addTrainingDetails(s);
//    }

    @RequestMapping(method=RequestMethod.POST,value = "/mentors")
    public void addUsers(@RequestBody MentorSignUpModel s) {

//        System.out.println("at controller"+s.getSkills());
        userService.addUserDetails(s);
    }
    @RequestMapping(method=RequestMethod.POST,value = "/search")
    public ArrayList<Results> searchMentors(@RequestBody SearchForm s) {

//        System.out.println("at controller"+s.getSkills());
//        userService.addUserDetails(s);
//        ArrayList<Results> temp = userRepository.findMentors(s.getFrom(),s.getCourse(),s.getTimeslot());
//        System.out.println("Hi there"+temp.get(0).getUserName());
        return resultsRepository.findMentors(s.getFrom(),s.getCourse(),s.getTimeslot());
    }
    @RequestMapping(method=RequestMethod.POST,value = "/skills")
    public void addSkills(@RequestBody Skills s) {

//        System.out.println("at controller"+s.getSkills());
//        userService.addUserDetails(s);
        skillsRepository.save(s);
    }
    @RequestMapping(method=RequestMethod.PUT,value = "/mentors/{id}")
    public void updateUser(@RequestBody Users s,@PathVariable String id){
        userService.updateUser(s,id);
    }

//    @RequestMapping(method=RequestMethod.PUT,value = "/trainings/{id}")
//    public void updateTraining(@RequestBody Trainings s,@PathVariable String id){
//        trainingsService.updateTraining(s, id);
//    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/mentors/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/skills/{id}")
    public void deleteSkill(@PathVariable String id) {
        skillsRepository.deleteById(id);
    }

}