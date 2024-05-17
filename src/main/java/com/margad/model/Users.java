package com.margad.model;

import com.margad.util.Account;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class Users {
    @Id
    private String ID;
    private String firstName;
    private String lastName;
    private String password;
    private Date accountCreatedDate;
    private List<Account> accounts;

}
