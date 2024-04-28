package com.rushi.springmongojoblist.joblisting.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class User {

    private String _id;
    private String name;

    private String email;

    private String password;
}
