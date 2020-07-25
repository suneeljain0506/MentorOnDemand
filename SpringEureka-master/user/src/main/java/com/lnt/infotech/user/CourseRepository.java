package com.lnt.infotech.user;

import com.lnt.infotech.user.entities.Course;
import org.springframework.data.repository.CrudRepository;


//import com.lnt.infotech.entities.Trainings;
//import com.lnt.infotech.entities.Users;

public interface CourseRepository extends CrudRepository<Course, String> {

}
