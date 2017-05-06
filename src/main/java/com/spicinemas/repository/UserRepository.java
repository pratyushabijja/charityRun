package com.spicinemas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spicinemas.model.User;

public interface UserRepository extends MongoRepository<User, Long>{
    public User findByPhoneNumber(String phoneNumber);
}
