package com.margad.controller;


import com.margad.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
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
