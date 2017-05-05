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
public class User {
	
	private String accessToken;
	
	private String name;
	
	private String email;
	
	private String phoneNumber;
	
	private String age;
	
	private String location;
	
	private Preferences preferences;
	
	private PurchaseHistory purchaseHistory;
	
}