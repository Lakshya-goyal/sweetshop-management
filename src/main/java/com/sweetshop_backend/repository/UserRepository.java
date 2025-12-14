package com.sweetshop_backend.repository;

import com.sweetshop_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String usernaem);
}
