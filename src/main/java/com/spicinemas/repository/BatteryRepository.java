package com.spicinemas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spicinemas.model.Battery;
import com.spicinemas.model.Movie;

public interface BatteryRepository extends MongoRepository<Battery, Long>{

}
