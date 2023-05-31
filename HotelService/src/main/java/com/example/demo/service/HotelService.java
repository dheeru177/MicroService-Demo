package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repo.HotelRepo;

@Service
public class HotelService {
	
	


@Autowired	
HotelRepo hotelRepo;

public void addHotel(Hotel hotel) {
	// TODO Auto-generated method stub
	
	hotelRepo.save(hotel);
	
}

public List<Hotel> getAllHotels() {
	// TODO Auto-generated method stub
	
	return hotelRepo.findAll();
}

public Hotel getHotelById(int hotelId) {
	// TODO Auto-generated method stub
	
	return hotelRepo.findById(hotelId).get();
}	
	


	
}
