package com.spicinemas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Movie;
import com.spicinemas.model.NotifyUser;
import com.spicinemas.model.ShowTime;
import com.spicinemas.model.User;
import com.spicinemas.repository.MovieRepository;
import com.spicinemas.repository.NotificationRepository;
import com.spicinemas.repository.UserRepository;

@RestController
public class notifyMeController implements BaseController {
	
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	NotificationRepository notificationRepository;
	
	@GetMapping(value = "/notifyMe")
	public ResponseEntity<String> notify(@RequestParam String uid, @RequestParam String date, @RequestParam String movieId) {
		System.out.println("Movie lookup:"+movieId);
		Movie m = movieRepository.findByUid(movieId);
		String releaseDate = m.getReleaseDate();
		String mId = m.getUid();
		User user = userRepository.findByPhoneNumber(uid);
		NotifyUser nU = notificationRepository.findByMovieId(mId);
		System.out.println(nU);
		if(nU != null){
			List<User> users = nU.getUsers();
			users.add(user);
			nU.setUsers(users);
		} else {
			List<User> users = new ArrayList<User>();
			users.add(user);
			nU = new NotifyUser(mId, releaseDate, users);
		}
		System.out.println(nU);
		notificationRepository.save(nU);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
}
