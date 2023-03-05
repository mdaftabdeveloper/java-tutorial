package com.techxtutor.oes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techxtutor.oes.model.User;
import com.techxtutor.oes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User getUserById(long id) {
		
		Optional<User> optUser = userRepository.findById(id);
		User user = null;
		
		if(optUser.isPresent()) {
			user = optUser.get();
		}else {
			throw new RuntimeException("User not found for id :: "+ id);
		}
		
		return user;
	}

	@Override
	public void deleteUserById(long id) {

		userRepository.deleteById(id);
		
	}

}
