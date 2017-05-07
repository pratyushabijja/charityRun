package com.spicinemas.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection="NotifyUser")
@AllArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
@Getter
@Setter
public class NotifyUser {

	public NotifyUser(String mId, String releaseDate2, List<User> users2) {
		// TODO Auto-generated constructor stub
		movieId = mId;
		releaseDate = releaseDate2;
		users = users2;
	}
	
	public NotifyUser(){}

	@Id
	String id;
	
	String movieId;
	
	String releaseDate;
	
	List<User> users;
	
}
