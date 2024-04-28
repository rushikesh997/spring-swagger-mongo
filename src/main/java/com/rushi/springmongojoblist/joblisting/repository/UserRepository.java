package com.rushi.springmongojoblist.joblisting.repository;

import com.rushi.springmongojoblist.joblisting.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmail(String email);
}
