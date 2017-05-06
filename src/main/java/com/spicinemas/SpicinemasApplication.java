package com.spicinemas;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spicinemas.notification.NotificationUtil;

@SpringBootApplication
public class SpicinemasApplication {
	
	@Autowired
	NotificationUtil notifUtil;

	public static void main(String[] args) {
		SpringApplication.run(SpicinemasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> notifUtil.sendDummyNotification();
	}
}
