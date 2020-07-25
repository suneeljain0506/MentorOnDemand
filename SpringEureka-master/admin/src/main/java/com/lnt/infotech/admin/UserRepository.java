package com.lnt.infotech.admin;

import org.springframework.data.repository.CrudRepository;

import com.lnt.infotech.admin.entities.Users;

public interface UserRepository extends CrudRepository<Users, String> {

}
