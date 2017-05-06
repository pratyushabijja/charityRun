package com.spicinemas.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Screen")
@AllArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
@Getter
@Setter
public class Screen {
	
	final int MAX_ROWS = 100;
	final int MAX_COLUMNS = 100;
	
	private String uid;
	private String Name;
	private int[][] seat_layout = new int[MAX_ROWS][MAX_COLUMNS];
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int[][] getSeat_layout() {
		return seat_layout;
	}
	public void setSeat_layout(int[][] seat_layout) {
		this.seat_layout = seat_layout;
	}
	
}
