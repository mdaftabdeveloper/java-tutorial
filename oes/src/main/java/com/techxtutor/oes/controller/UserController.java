package com.techxtutor.oes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.techxtutor.oes.model.User;
import com.techxtutor.oes.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// display a list of users
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		
		return "index";
	}
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		// Create a model attribute to bind form data
		User user =  new User();
		model.addAttribute("user", user);
		
		return "new_user";
	}
	
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// Save user to database
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
		// Get user from the service
		User user = userService.getUserById(id);
		
		// Set user as model attribute to pre-populate the form
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id") long id) {
		
		// Call delete user method
		
		userService.deleteUserById(id);
		
		return "redirect:/";
	}

}
