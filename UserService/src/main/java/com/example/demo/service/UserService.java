package com.example.demo.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;

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
		 User user = userRepo.findById(userId).get();
		try {
		  ArrayList<Rating> array = restTemplate.getForObject("http://localhost:9094/rating/getRatingByUserId/2", ArrayList.class);
	
		
	      user.setRating(array);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception");
			System.out.println(user.getRating());
		}
       
        
        return user;
	}
	
	
}
