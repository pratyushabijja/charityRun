package com.spicinemas.model;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Preferences {
	private String preferredDayInWeek;
	
	private String preferredSlot;
	
	private String preferredSeats;
	
	HashMap<String,String> otherPreferences = new HashMap<String,String>();

	public String getPreferredDayInWeek() {
		return preferredDayInWeek;
	}

	public void setPreferredDayInWeek(String preferredDayInWeek) {
		this.preferredDayInWeek = preferredDayInWeek;
	}

	public String getPreferredSlot() {
		return preferredSlot;
	}

	public void setPreferredSlot(String preferredSlot) {
		this.preferredSlot = preferredSlot;
	}

	public String getPreferredSeats() {
		return preferredSeats;
	}

	public void setPreferredSeats(String preferredSeats) {
		this.preferredSeats = preferredSeats;
	}

	public HashMap<String, String> getOtherPreferences() {
		return otherPreferences;
	}

	public void setOtherPreferences(HashMap<String, String> otherPreferences) {
		this.otherPreferences = otherPreferences;
	} 
}
