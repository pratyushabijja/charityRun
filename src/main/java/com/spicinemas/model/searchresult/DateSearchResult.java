package com.spicinemas.model.searchresult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Movie")
@AllArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class DateSearchResult {

	public DateSearchResult() {
		
	}

	private String date;
	
	HashMap<String, HashSet<HashMap<String, HashSet<String>>>> theatre;

}
