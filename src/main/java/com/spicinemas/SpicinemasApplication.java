package com.spicinemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spicinemas.notification.NotificationUtil;

@SpringBootApplication
public class SpicinemasApplication {

	@Autowired
	NotificationUtil notifUtil;

	public static void main(String[] args) {
		SpringApplication.run(SpicinemasApplication.class, args);
	}

	@Bean
	@CrossOrigin(origins = "*")
	WebMvcConfigurer configurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
			}
		};
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// return args -> notifUtil.sendDummyNotification();
	// }
}
