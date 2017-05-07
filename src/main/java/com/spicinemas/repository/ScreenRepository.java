package com.spicinemas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spicinemas.model.Movie;
import com.spicinemas.model.Screen;

public interface ScreenRepository extends MongoRepository<Screen, Long>  {
	public Screen findByUid(String uid);
}
