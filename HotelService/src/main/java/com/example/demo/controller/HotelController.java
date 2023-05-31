package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

@Autowired	
HotelService hotelService;


@PostMapping("/addHotel")
public void addHotel(@RequestBody Hotel hotel)
{

hotelService.addHotel(hotel);	

}


@GetMapping("/getAllHotels")
public List<Hotel> getAllHotels(){
	
return hotelService.getAllHotels();	
	
}

@GetMapping("/getHotelById/{hotelId}")
public Hotel getHotelById(@PathVariable int hotelId)
{
	
return hotelService.getHotelById(hotelId);
	
}

	
}
