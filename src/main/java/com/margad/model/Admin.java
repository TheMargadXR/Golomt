package com.margad.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "admin")
public class Admin {
    @Id
    private String ID;
    private String firstName;
    private String lastName;
    private Date accountCreatedDate;
    private String userName;
    private String password;

}
