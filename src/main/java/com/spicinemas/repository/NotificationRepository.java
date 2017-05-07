package com.spicinemas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spicinemas.model.NotifyUser;
import com.spicinemas.model.User;

public interface NotificationRepository extends MongoRepository<NotifyUser, Long>{
	public List<NotifyUser> findByReleaseDate(String date);
	public NotifyUser findByMovieId(String movieId);
}
