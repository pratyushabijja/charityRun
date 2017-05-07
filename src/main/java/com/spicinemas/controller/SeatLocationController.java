package com.spicinemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Screen;
import com.spicinemas.repository.ScreenRepository;

@RestController
public class SeatLocationController implements BaseController {
	
	@Autowired
	ScreenRepository screenRepository;
	
	@GetMapping(value = "/seatDetail")
	public ResponseEntity<Object> seatDetail(@RequestParam String theatreId, @RequestParam String screenId, @RequestParam String slot) {
		
		Screen s = screenRepository.findByUid(screenId);
		
		return new ResponseEntity<Object>(s,HttpStatus.ACCEPTED);
	}
}
