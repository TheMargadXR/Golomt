package com.margad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "bank")
public class Bank {
    @Id
    private String ID;
    private String name;

}
