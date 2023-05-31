package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	
	@Autowired
	UserRepo userRepo;

	@PostMapping("/addUser")
	public void addUser(User user) {
		// TODO Auto-generated method stub
	
       userRepo.save(user);	
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepo.findAll();
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).get();
	}
	
	
}
