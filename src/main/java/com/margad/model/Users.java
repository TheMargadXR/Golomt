package com.margad.model;

import com.margad.util.Account;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class Users {
    @Id
    private String userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Date userCreatedDate;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private List<FrequencyTransaction> frequencies;

    public Users(Date userCreatedDate, String password, String userName, String lastName, String firstName, String userID) {
        this.userCreatedDate = userCreatedDate;
        this.password = password;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUserCreatedDate() {
        return userCreatedDate;
    }

    public void setUserCreatedDate(Date userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<FrequencyTransaction> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(List<FrequencyTransaction> frequencies) {
        this.frequencies = frequencies;
    }
}
