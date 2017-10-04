package com.charityRun.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charityRun.model.User;
import com.charityRun.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CharityRunController implements BaseController {

	@Autowired
	UserRepository userRepo;

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> signup(@RequestBody User user) {

		User user_found = null;
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		// log.info("Requesting resource /v1/api/login");
		System.out.println("Requesting resource" + user.getEmail());
		try {
			user_found = userRepo.findByEmailAndParticipantId(user.getEmail(), user.getParticipantId());
			if (user_found != null) {
				responseMap.put("status", "SUCCESS");
			} else {
				responseMap.put("status", "FAILURE");
			}
			responseMap.put("result", user_found);
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<Object>(responseMap, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}

	@PostMapping(value = "/updateRunDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> userUpdate(@RequestBody User user) {
		User user_found = userRepo.findByEmailAndParticipantId(user.getEmail(), user.getParticipantId());
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		if (user_found != null) {
			if (user.getStartDateTime() != null && user.getEndDateTime() != null && user.getDistanceCovered() != null
					&& user.getNoOfSteps() != null)
				user_found.setStartDateTime(user.getStartDateTime());
			user_found.setEndDateTime(user.getEndDateTime());
			user_found.setDistanceCovered(user.getDistanceCovered());
			user_found.setNoOfSteps(user.getNoOfSteps());
			try {
				userRepo.save(user_found);
				System.out.println("Saved");
				responseMap.put("status", "SUCCESS");
				responseMap.put("result", user_found);
				return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
			} catch (Exception e) {
				responseMap.put("status", "Failure");
				return new ResponseEntity<Object>(responseMap, HttpStatus.NOT_FOUND);
			}
		} else {
			responseMap.put("status", "Failure");
			return new ResponseEntity<Object>(responseMap, HttpStatus.NOT_FOUND);

		}

	}
}
