package com.techxtutor.oes.service;

import java.util.List;

import com.techxtutor.oes.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	void saveUser(User user);
	
	User getUserById(long id);
	
	void deleteUserById(long id);

}
