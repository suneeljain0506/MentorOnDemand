package com.lnt.infotech.admin;

import java.util.ArrayList;
//import java.util.List;

import com.lnt.infotech.admin.entities.Skills;
import com.lnt.infotech.admin.entities.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.infotech.admin.entities.Users;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    TechnologiesService technologiesService;

    @Autowired
    private RestTemplate restTemplate;

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

    @RequestMapping("/admins")
    public ArrayList<MentorSignUpModel> getList(){
        return userService.getUserList();
    }

    @RequestMapping("/technologies")
    public ArrayList<Technologies> getTechList(){
        return technologiesService.getTechList();
    }

    @RequestMapping("/blockuser/{id}")
    public void blockUser(@PathVariable String id){

        restTemplate.getForObject("http://user/block/"+id,Users.class);

    }
    @RequestMapping("/blockmentor/{id}")
    public void blockMentor(@PathVariable String id){

        restTemplate.getForObject("http://mentor/block/"+id,Users.class);

    }

    @RequestMapping("/admins/{id}")
    public Users getUserList(@PathVariable String id){
        return userService.getUser(id);
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

    @RequestMapping(method=RequestMethod.POST,value = "/admins")
    public void addUsers(@RequestBody MentorSignUpModel s) {

//        System.out.println("at controller"+s.getSkills());
        userService.addUserDetails(s);
    }
    @RequestMapping(method=RequestMethod.POST,value = "/technologies")
    public void addTechnology(@RequestBody Technologies s) {

//        System.out.println("at controller"+s.getSkills());
//        userService.addUserDetails(s);
        technologiesService.addTechnology(s);
        Skills skill = new Skills(s.getTechnology());
        restTemplate.postForObject("http://mentor/skills",skill,Skills.class);

    }
    @RequestMapping(method=RequestMethod.PUT,value = "/admins/{id}")
    public void updateUser(@RequestBody Users s,@PathVariable String id){
        userService.updateUser(s,id);
    }

//    @RequestMapping(method=RequestMethod.PUT,value = "/trainings/{id}")
//    public void updateTraining(@RequestBody Trainings s,@PathVariable String id){
//        trainingsService.updateTraining(s, id);
//    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/admins/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/technologies/{id}")
    public void deleteTech(@PathVariable String id) {
        technologiesService.deleteTech(id);
        restTemplate.delete("http://mentor/skills/"+id);
    }

}