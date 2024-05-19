package com.margad.controller;


import com.margad.repository.FrequencyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frequencytransaction")
public class FrequencyTransactionController {
    @Autowired
    private FrequencyTransactionRepository frequencyTransactionRepository;
    @GetMapping("/add")
    public String addUser() {
        try {
            return "Амжилттай";
        } catch (Exception e) {
            return "Алдаа : " + e.getMessage();
        }
    }
}
