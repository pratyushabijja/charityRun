package com.spicinemas.model;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection="userinfo")
@AllArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
@Getter
@Setter
public class Preferences {
	private String preferredDayInWeek;
	
	private String preferredSlot;
	
	private String preferredSeats;
	
	HashMap<String,String> otherPreferences = new HashMap<String,String>(); 
}
