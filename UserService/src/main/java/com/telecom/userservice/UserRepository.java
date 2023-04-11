package com.telecom.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUsername(String username);

}
