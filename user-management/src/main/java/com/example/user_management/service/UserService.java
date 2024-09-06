package com.example.user_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_management.model.User;
import com.example.user_management.repository.UserRepository;

@Service
public class UserService {
  
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	public String createUser(User user) {
		 userRepository.save(user);
		return "new user added sucesfully";
	}
	
	public String updateUser(Long id , User userDetails) {
		User user =  userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		 userRepository.save(user);
		 return "user record update Successfully";
	}
	
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "Users record deleted sucessfully";
	}
}
