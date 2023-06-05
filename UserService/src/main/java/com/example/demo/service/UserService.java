package com.example.demo.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
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
		List<User> userList = userRepo.findAll();
		
		List<User> newUser = new ArrayList<>();
		for(User u : userList)
		{
			  Rating[] array = restTemplate.getForObject("http://localhost:9094/rating/getRatingByUserId/" + u.getUserId(), Rating[].class);
				List<Rating> ratList =  Arrays.stream(array).toList();
				List<Rating> newRating = new ArrayList<>();
 				for(Rating r : ratList)
				{
					
					Hotel  hotel = restTemplate.getForObject("http://localhost:9096/hotel/getHotelById/"+r.getHotelId(), Hotel.class);
					r.setHotel(hotel);			
					newRating.add(r);
				}
				
				u.setRating(newRating);
				newUser.add(u);
			
			
		}
		return newUser;
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		 User user = userRepo.findById(userId).get();
		
		try {
		  Rating[] array = restTemplate.getForObject("http://localhost:9094/rating/getRatingByUserId/" + userId, Rating[].class);
	
		  ArrayList<Rating> rsList = new ArrayList<>();
		  
		  for(Rating r: array)
		  {
			  
			  
		Hotel  hotel = restTemplate.getForObject("http://localhost:9096/hotel/getHotelById/"+r.getHotelId(), Hotel.class);
			 System.out.println(hotel.getHotelName());
			 r.setHotel(hotel);
			 rsList.add(r);
		  }
		
	      user.setRating(rsList);
		}
		catch (Exception e) {
			// TODO: handle exception

			System.out.println("exception");
			System.out.println(user.getRating());
		}
       
        
        return user;
	}
	
	
}
