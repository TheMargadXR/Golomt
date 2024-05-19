package com.margad.controller;


import com.margad.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankRepository bankRepository;

    @GetMapping("/add")
    public String addUser(@RequestBody String body) {
        try {
            System.out.println(body);
            return body;
        } catch (Exception e) {
            return "Алдаа : " + e.getMessage();
        }
    }
}
