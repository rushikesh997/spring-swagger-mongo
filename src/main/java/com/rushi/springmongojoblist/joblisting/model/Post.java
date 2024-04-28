package com.rushi.springmongojoblist.joblisting.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "jobs")
public class Post {

    private String profile;
    private String desc;
    private int exp;
    private String techs[];

}
