package com.telecom.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.userservice.UserRepository;
import com.telecom.userservice.entities.User;
import com.telecom.userservice.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins={"*","http://localhost:3000/"})
public class Controller {
	
	@Autowired
	private UserService userService;
	
	//controller to get all users
	@GetMapping("/all")
	public ResponseEntity<List<User>>  getAllUsers(){
		
		List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	// to get user by mobNo(id)
	@GetMapping("/{mobNo}")
	public ResponseEntity<User> getUserByMobNo(@PathVariable String mobNo){
		
		User user = userService.getUserByMobNo(mobNo);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user){
		User user1 = userService.adduser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("done");
	}
	
	@PutMapping("/{mobNo}")
	public ResponseEntity<String> updateUser( @PathVariable String mobNo,@RequestBody User user){
		User user1 = userService.updateUser(user, mobNo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("done");
	}

}
