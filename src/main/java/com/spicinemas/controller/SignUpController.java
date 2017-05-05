package com.spicinemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Token;
import com.spicinemas.model.User;
import com.spicinemas.repository.UserRepository;

@RestController
@RequestMapping("/v1/api")
public class SignUpController {
	
	@Autowired
	UserRepository userRepo;

	@PostMapping(value="/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signup(@RequestBody Token token){
		
		User u = new User("Amr", "slkdj");
		userRepo.save(u);
		return "HEllo WOrld";
	}
}
