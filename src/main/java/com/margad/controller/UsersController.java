package com.margad.controller;

import com.margad.model.Users;
import com.margad.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/add")
    public String addUser(@RequestParam String username, @RequestParam String password) {
        try {
            Users user = new Users();
            user.setUserID("10008");
            user.setUserName(username);
            user.setPassword(password);
            usersRepository.insert(user);
            return "Амжилттай";
        } catch (Exception e) {
            return "Алдаа : " + e.getMessage();
        }
    }
}
