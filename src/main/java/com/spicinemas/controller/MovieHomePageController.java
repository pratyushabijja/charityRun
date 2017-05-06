package com.spicinemas.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Movie;
import com.spicinemas.model.ShowTime;
import com.spicinemas.repository.MovieRepository;
import com.spicinemas.repository.ShowTimeRepository;
import com.spicinemas.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieHomePageController implements BaseController {
	
	@Autowired
	ShowTimeRepository showTimeRepo;
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping(value = "/movieHomePage")
	public ResponseEntity<List<Movie>> homePage() {
/*		Sort s = new Sort(Sort.Direction.DESC, "date");
		s.and(new Sort(Sort.Direction.ASC,"slots"));
*/		List<ShowTime> showTimes = showTimeRepo.findAll();
		List<Movie> movies = new ArrayList<Movie>();
		for(ShowTime showTime : showTimes){
/*			System.out.println(showTime.getSlots());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String tNow = sdf.format(new Date());
			sdf = new SimpleDateFormat("YYYYMMDD");
			String dNow = sdf.format(new Date());
			if(dNow.compareTo(showTime.getDate())<0){
*/				Movie m = movieRepository.findByUid(showTime.getMovieId());
				movies.add(m);
			//}			
		}
		return new ResponseEntity(movies, HttpStatus.ACCEPTED);
	}
}
