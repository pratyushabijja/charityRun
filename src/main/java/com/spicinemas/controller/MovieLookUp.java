package com.spicinemas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Movie;
import com.spicinemas.model.ShowTime;
import com.spicinemas.model.User;
import com.spicinemas.repository.MovieRepository;
import com.spicinemas.repository.ShowTimeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieLookUp implements BaseController {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ShowTimeRepository showTimeRepository;
	
	@GetMapping(value = "/movie")
	public ResponseEntity<Object> movieLook(@RequestParam String uid) {
		System.out.println("Movie lookup:"+uid);
		Movie m = movieRepository.findByUid(uid);
		ShowTime s = showTimeRepository.findByMovieId(m.getUid());
		List<Object> sm = new ArrayList<Object>();
		sm.add(m);
		sm.add(s);
		return new ResponseEntity<Object>(sm,HttpStatus.ACCEPTED);
		
	}
}
