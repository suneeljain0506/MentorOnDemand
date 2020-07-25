package com.lnt.infotech.user;

import org.springframework.data.repository.CrudRepository;

import com.lnt.infotech.user.entities.Users;

public interface UserRepository extends CrudRepository<Users, String> {

}
