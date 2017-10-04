package com.charityRun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.charityRun.model.User;

public interface UserRepository extends MongoRepository<User, Long>{
    public User findByEmailAndParticipantId(String email,String participantId);
}
