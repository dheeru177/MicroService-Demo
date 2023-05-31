package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
@Autowired
UserService userService;

@PostMapping("/adduser")
public void addUser(@RequestBody User user)
{
	
	userService.addUser(user);

}


@GetMapping("/getAllusers")
public List<User> getAllUsers(){
	
return userService.getAllUsers();	
	
}
	

@GetMapping("/getUserById/{userId}")
public User getUserById(@PathVariable int userId)
{
	
return userService.getUserById(userId);
}


}
