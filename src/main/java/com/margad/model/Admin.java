package com.margad.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "admin")
public class Admin {
    @Id
    private String ID;
    private String firstName, lastName, userName , password;
    private Date accountCreatedDate;


    public Admin(String ID, Date accountCreatedDate, String firstName, String lastName, String password, String userName) {
        this.ID = ID;
        this.accountCreatedDate = accountCreatedDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
