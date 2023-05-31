package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rating;
import com.example.demo.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	
	@PostMapping("/addRating")
	public void addRating(@RequestBody Rating rating) {
		
		
		ratingService.addRating(rating);
		
	}
	
	@GetMapping("/getAllRatings")
	public List<Rating> getAllRatings(){
		
	return ratingService.getAllRatings();	
		
		
	}
	
	
	@GetMapping("getRatingById/{ratingId}")
	public 	Rating getRatingById(@PathVariable int ratingId) {
		
	return ratingService.getRatingById(ratingId);	
		
	}
	
	@GetMapping("/getRatingByUserId/{userId}")
	public List<Rating> getRatingByUserId(@PathVariable int userId)
	{
		
	return ratingService.getRatingByUserId(userId);
		
		
	}

	@GetMapping("/getRatingByHotelId/{hotelId}")
	public List<Rating> getRatingByHotelId(@PathVariable int hotelId){
		
	return ratingService.getRatingByHotelId(hotelId);	
		
	}
	
	
	
}
