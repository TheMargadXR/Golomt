package com.margad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bank")
public class Bank {
    private String bankID;
    private String bankName;

    public Bank() {
    }

    public Bank(String bankID, String bankName) {
        this.bankID = bankID;
        this.bankName = bankName;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
