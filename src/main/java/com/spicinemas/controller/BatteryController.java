package com.spicinemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Battery;
import com.spicinemas.model.User;
import com.spicinemas.notification.NotificationUtil;
import com.spicinemas.repository.BatteryRepository;
import com.spicinemas.repository.UserRepository;

@RestController
public class BatteryController implements BaseController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BatteryRepository batteryRepository;

	@Autowired
	NotificationUtil notifUtil;
	
	@GetMapping(value = "/battery")
	public ResponseEntity<String> battery(@RequestParam String uid) throws Exception {
		User u = userRepository.findByPhoneNumber(uid);
		Battery b = new Battery(uid,u.getName());
		batteryRepository.save(b);
		notifUtil.sendNotification(u.getFireBaseToken(), "Seems your battery is low");
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
}
