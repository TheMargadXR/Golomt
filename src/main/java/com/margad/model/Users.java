package com.margad.model;

import com.margad.util.Account;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
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
    private String email;
    private String token;
    private String salt;
    private String userCreatedDate;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private List<FrequencyTransaction> frequencies;


    public Users() {
        this("", "", "", "", "", "", "", "", null, null, null);
    }

    public Users(String salt, String firstName, String lastName, String password, String token, String userID, String userName, String userCreatedDate, List<Account> accounts, List<Transaction> transactions, List<FrequencyTransaction> frequencies) {
        this.salt = salt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.token = token;
        this.userName = userName;
        this.accounts = accounts;
        this.transactions = transactions;
        this.frequencies = frequencies;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserCreatedDate() {
        return userCreatedDate;
    }

    public void setUserCreatedDate(String userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }
}
