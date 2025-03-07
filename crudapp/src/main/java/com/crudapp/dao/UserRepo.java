package com.crudapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//CrudRepository<User, Integer>  can also this instead of jpaRepo..

import com.crudapp.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	public List<User> findByName(String name);
	
	
}
