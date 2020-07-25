package com.lnt.infotech.user;

import java.util.ArrayList;
//import java.util.List;

import com.lnt.infotech.user.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    CourseService courseService;

//    @Autowired
//    TrainingsService trainingsService;
//
//    @Autowired
//    SearchService searchService;
//    public void initializedb() {
//        Skills skills = new Skills("na");
//        skillsRepository.save(skills);
//    }

    @RequestMapping("")
    public String hi() {
       // initializedb();
        return "Hi";
    }

    @RequestMapping("/hello")
    public String hello() {
       // initializedb();
        return "Hello!";
    }

    @RequestMapping("/users")
    public ArrayList<MentorSignUpModel> getList(){
       // initializedb();
        return userService.getUserList();
    }


    @RequestMapping("/courses")
    public ArrayList<Course> getCourseList(){
       // initializedb();
        return courseService.getCourseList();
    }

    @RequestMapping("/users/{id}")
    public Users getUserList(@PathVariable String id){
       // initializedb();
        return userService.getUser(id);
    }
    @RequestMapping("/block/{id}")
    public void blockUser(@PathVariable String id){
       // initializedb();
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

    @RequestMapping(method=RequestMethod.POST,value = "/users")
    public void addUsers(@RequestBody MentorSignUpModel s) {
      //  initializedb();

        System.out.println("at controller"+s.getSkills());
        userService.addUserDetails(s);
    }
    @RequestMapping(method=RequestMethod.POST,value = "/courses")
    public void addCourses(@RequestBody Course s) {

        courseService.addCourse(s);
    }
    @RequestMapping(method=RequestMethod.PUT,value = "/users/{id}")
    public void updateUser(@RequestBody Users s,@PathVariable String id){
       // initializedb();
        userService.updateUser(s,id);
    }

//    @RequestMapping(method=RequestMethod.PUT,value = "/trainings/{id}")
//    public void updateTraining(@RequestBody Trainings s,@PathVariable String id){
//        trainingsService.updateTraining(s, id);
//    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
    public void deleteUser(@PathVariable String id) {
       // initializedb();
        userService.deleteUser(id);
    }

}