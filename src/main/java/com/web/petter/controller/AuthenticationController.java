package com.web.petter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.petter.model.Customer;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/authentication")
public class AuthenticationController {
	 
	@GetMapping("/validate/{username}/{password}")
	    public Boolean validateUser(@PathVariable String username,@PathVariable String password){
	        return username.equals("admininicial") && password.equals("admin123456");
	        
	    }

}
