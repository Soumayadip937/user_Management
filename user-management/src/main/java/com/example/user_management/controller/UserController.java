package com.example.user_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_management.model.User;
import com.example.user_management.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:9000") 
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	 public List<User> getAllUsers(){
		return userService.getAllUsers();
}
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public String createUser(@RequestBody User user){
		
		return userService.createUser(user);
	}
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable Long id,@RequestBody User userDetails){
		return userService.updateUser(id, userDetails);
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return "deleted Sucesfully";
	}
	

}
