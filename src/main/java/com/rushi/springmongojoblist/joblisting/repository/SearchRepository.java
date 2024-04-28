package com.rushi.springmongojoblist.joblisting.repository;

import com.rushi.springmongojoblist.joblisting.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SearchRepository {

        List<User> findByText(String text);
}
