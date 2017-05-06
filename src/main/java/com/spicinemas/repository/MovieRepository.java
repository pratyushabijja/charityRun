package com.spicinemas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spicinemas.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, Long> {
	
	public Movie findByUid(String uid);

}
