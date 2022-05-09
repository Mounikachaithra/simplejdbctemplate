package com.serole.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serole.demo.dao.UserRepository;
import com.serole.demo.entity.User;

@RestController
public class UserControlller {
	@Autowired
	UserRepository UserRepository;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return  UserRepository.saveUser(user);
	}
	
	@PutMapping("/users")
	public User updateUse(@RequestBody User user) {
		return  UserRepository.updateUser(user);
	}
	
	@GetMapping("/getuser/{id}")
	public User geuserById(@PathVariable("id") int id) {

		return UserRepository.getUserById(id);
	}

	@DeleteMapping("/DeleteById/{id}")
	public String deleteById(@PathVariable("id") int id) {
		return UserRepository.deleteById(id);
	}

	@GetMapping("/AllUsers")
	public List<User> allUsers() {
		return UserRepository.allUsers();
	}

}

   
	   
   

   

