package com.rushi.springmongojoblist.joblisting.repository;

import com.rushi.springmongojoblist.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
