package com.margad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "frequencies")
public class FrequencyTransaction {
    @Id
    private String ID;
    private boolean active;
    private String transferAccount;
    private String transferBank;
    private String recipientAccount;
    private String recipientBank;
    private double frequencyAmount;
    private String currency;
    private Date createdDate;
    private Date transactionDate;
    private String transactionDescription;
    enum FrequencyChoose{
        DAY,
        WEEK,
        MONTH,
    }

    public FrequencyTransaction(String currency, String ID, boolean active, String transferAccount, String transferBank, String recipientAccount, String recipientBank, double frequencyAmount, Date createdDate, Date transactionDate , String transactionDescription) {
        this.currency = currency;
        this.ID = ID;
        this.active = active;
        this.transferAccount = transferAccount;
        this.transferBank = transferBank;
        this.recipientAccount = recipientAccount;
        this.recipientBank = recipientBank;
        this.frequencyAmount = frequencyAmount;
        this.createdDate = createdDate;
        this.transactionDate = transactionDate;
        this.transactionDescription = transactionDescription;
    }

    public String getRecipientBank() {
        return recipientBank;
    }

    public void setRecipientBank(String recipientBank) {
        this.recipientBank = recipientBank;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTransferAccount() {
        return transferAccount;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public String getTransferBank() {
        return transferBank;
    }

    public void setTransferBank(String transferBank) {
        this.transferBank = transferBank;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public double getFrequencyAmount() {
        return frequencyAmount;
    }

    public void setFrequencyAmount(double frequencyAmount) {
        this.frequencyAmount = frequencyAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
