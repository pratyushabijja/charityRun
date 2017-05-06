package com.spicinemas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController implements BaseController{

	@GetMapping(value = "/greeting")
	public ResponseEntity<String> greeting() {
		
		//log.info("Requesting resource /v1/api/greeting");

		return new ResponseEntity<String>("Hello World", HttpStatus.ACCEPTED);
	}
}
