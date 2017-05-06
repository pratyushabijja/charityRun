package com.spicinemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.User;
import com.spicinemas.repository.UserRepository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SignUpController implements BaseController {

	@Autowired
	UserRepository userRepo;

	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> signup(@RequestBody User user) {

		//log.info("Requesting resource /v1/api/signup");
		System.out.println("Requesting resource"+user.getPhoneNumber());
		try {
			userRepo.save(user);
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/userUpdate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userUpdate(@RequestBody User user){
		String phoneNumber = user.getPhoneNumber();
		User oldUser = userRepo.findByPhoneNumber(phoneNumber);
		System.out.println(oldUser.getId());
		System.out.println(oldUser.getPhoneNumber());
		user.setId(oldUser.getId());
		userRepo.save(user);
		System.out.println("Saved");
		return new ResponseEntity<String>("Success",HttpStatus.ACCEPTED);
	}
}
