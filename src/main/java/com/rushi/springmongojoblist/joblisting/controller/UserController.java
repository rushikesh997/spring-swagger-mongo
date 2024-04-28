package com.rushi.springmongojoblist.joblisting.controller;

import com.rushi.springmongojoblist.joblisting.model.Post;
import com.rushi.springmongojoblist.joblisting.repository.UserRepository;
import com.rushi.springmongojoblist.joblisting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/users/{email}")
    public User getAllUsers(@PathVariable String email) {
        return repo.findByEmail(email);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return repo.save(user);
    }
}
