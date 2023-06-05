package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rating;
import com.example.demo.repo.RatingRepo;

@Service
public class RatingService {
	
	@Autowired
	RatingRepo ratingRepo;

	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		ratingRepo.save(rating);
		
	}

	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		
		return ratingRepo.findAll();
		
	}

	public Rating getRatingById(int ratingId) {
		// TODO Auto-generated method stub
		
		return ratingRepo.findById(ratingId).get();
		
	}

	public List<Rating> getRatingByUserId(int userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	
	}

	public List<Rating> getRatingByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		
		return ratingRepo.findByHotelId(hotelId);
	}
	
	

}
