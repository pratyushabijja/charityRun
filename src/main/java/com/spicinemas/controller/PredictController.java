package com.spicinemas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PredictController implements BaseController{
	
	@GetMapping(value = "/movie")
	public ResponseEntity<Object> movieLook(@RequestParam String userId, @RequestParam String slotId) {
		
		return null;
	}
}
