package com.serole.demo.dao;

import java.util.List;

import com.serole.demo.entity.User;

public interface UserRepository {
	User saveUser(User user);
	User updateUser(User user);
	User getUserById(int id);
	String deleteById(int id);
	List<User> allUsers();
	

}
