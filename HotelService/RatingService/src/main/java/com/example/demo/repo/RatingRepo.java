package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer>{
	
	
	public List<Rating> findByUserId(int userId);
	
	
	public List<Rating> findByHotelId(int hotelId);
	
	
	

}
