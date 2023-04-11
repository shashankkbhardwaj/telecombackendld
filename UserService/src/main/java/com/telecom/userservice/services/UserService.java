package com.telecom.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.telecom.userservice.UserRepository;
import com.telecom.userservice.entities.User;
import com.telecom.userservice.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder byCryptPasswordEncoder;

	
	
	//to get all users
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	//to get single user by mobileno.
	public User getUserByMobNo(String mobNo) {
		User user = userRepository.findById(mobNo).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server" + mobNo));
		return user;
	}
	
	//add user
	public User adduser(User user) {
		
		user.setPassword(this.byCryptPasswordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}
	
	//update user
	public User updateUser(User user, String mobNo) {
		
		User usersave= userRepository.findByUsername(mobNo);
		
		user.setUsername(mobNo);
		user.setPassword(usersave.getPassword());
		
		return userRepository.save(user);
	}
	

}
