package com.spicinemas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spicinemas.model.ShowTime;
import com.spicinemas.model.User;

public interface ShowTimeRepository extends MongoRepository<ShowTime, Long> {
	public ShowTime findByMovieId(String movieId);
}
