package com.spicinemas.model;

import java.util.ArrayList;

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
public class Movie {
	
	private String ID;
	
	private String Title;
	
	private String ImdbId;
	
	private ArrayList<Scenes> SceneEmotions;
	
}