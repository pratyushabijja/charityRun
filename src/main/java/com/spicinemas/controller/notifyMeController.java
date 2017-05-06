package com.spicinemas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spicinemas.model.Movie;
import com.spicinemas.model.ShowTime;
import com.spicinemas.repository.MovieRepository;


public class notifyMeController implements BaseController {
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping(value = "/notifyMe")
	public ResponseEntity<String> notify(@RequestParam String uid, @RequestParam String date, @RequestParam String movieId) {
		System.out.println("Movie lookup:"+uid);
		Movie m = movieRepository.findByUid(uid);
		String releaseDate = m.getReleaseDate();
		
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
}
