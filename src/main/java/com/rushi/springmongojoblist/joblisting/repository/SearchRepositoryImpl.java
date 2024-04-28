package com.rushi.springmongojoblist.joblisting.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rushi.springmongojoblist.joblisting.model.Post;
import com.rushi.springmongojoblist.joblisting.model.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    List<User> users = new ArrayList<>();

    @Autowired
    MongoConverter converter;


    @Override
    public List<User> findByText(String text) {
        users = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection("users");
        AggregateIterable<Document> result = collection.aggregate(
                Arrays.asList(new Document("$search",
                                new Document("text",
                                new Document("query", text).append("path",
                                        Arrays.asList("name", "email")))),
                        new Document("$sort", new Document("name", 1L)),
                        new Document("$limit", 5L)));

        result.forEach(document -> users.add(converter.read(User.class, document)));
        return users;
    }
}
