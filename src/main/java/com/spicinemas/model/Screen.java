package com.spicinemas.model;

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
public class Screen {
	
	final int MAX_ROWS = 100;
	final int MAX_COLUMNS = 100;
	
	private String ID;
	private String Name;
	private int[][] seat_layout = new int[MAX_ROWS][MAX_COLUMNS];
	
}
