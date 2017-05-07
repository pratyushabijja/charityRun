package com.spicinemas.notification;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spicinemas.model.NotifyUser;
import com.spicinemas.model.User;
import com.spicinemas.repository.NotificationRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationScheduler {

	@Autowired
	NotificationRepository notifRepo;

	@Autowired
	NotificationUtil notifUtil;

	@Scheduled(cron = "0 0 6 * * *")
	public void notifyUsers() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();

		String date = dateFormat.format(cal);

		List<NotifyUser> listOfMovieWithUsers = notifRepo.findByReleaseDate(date);

		listOfMovieWithUsers.stream().forEach(p -> p.getUsers().stream()
				.forEach(user -> {
					try {
						notifUtil.sendDummyNotification(user.getFireBaseToken(), p.getMovieId());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}));

	}
}
