package com.lnt.infotech.mentor;

import com.lnt.infotech.mentor.entities.Results;
import com.lnt.infotech.mentor.entities.SearchResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lnt.infotech.mentor.entities.Users;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.ArrayList;

public interface UserRepository extends CrudRepository<Users, String> {

//    @Query(value="select * from user_progress where user_name = :username",nativeQuery = true)

}
