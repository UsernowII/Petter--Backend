package com.web.petter.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.petter.model.UserData;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/authentication")
public class AuthenticationController {
	 
	@GetMapping("/validate/{username}/{password}")
	public UserData validateUser(@PathVariable String username,@PathVariable String password){
		
		UserData user = new UserData();
		user.setResult(false);
		
		if (username.equals("adminbog") && password.equals("123")) {
			user.setUrl("http://localhost:8080/");
			user.setCity("Bogota");
			user.setResult(true);
		}
		else if (username.equals("adminmed") && password.equals("123")) {
			user.setUrl("http://localhost:8080/");
			user.setCity("Medellin");
			user.setResult(true);
		}
		else if (username.equals("admincal") && password.equals("123")) {
			user.setUrl("http://localhost:8080/");
			user.setCity("Cali");
			user.setResult(true);
		}
		
		return user;
	        
	}

}
