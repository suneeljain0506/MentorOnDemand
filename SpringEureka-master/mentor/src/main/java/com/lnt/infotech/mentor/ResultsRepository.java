package com.lnt.infotech.mentor;

import com.lnt.infotech.mentor.entities.Results;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.ArrayList;


//import com.lnt.infotech.entities.Trainings;
//import com.lnt.infotech.entities.Users;

public interface ResultsRepository extends CrudRepository<Results, String> {

    @Query(value="select users.user_name,trainer_details.experience,users.email from users,trainer_details,users_skills where trainer_details.email=users.email and users_skills.users_email=users.email and " +
            "trainer_details.startdate<=:fromdate and trainer_details.enddate>=:fromdate and trainer_details.timeslot=:timeslotno and users_skills.skills_skill=:course",nativeQuery = true)
    ArrayList<Results> findMentors(@Param(value="fromdate") Date fromdate, @Param(value="course") String course,
                                   @Param(value="timeslotno") String timeslotno);

}
