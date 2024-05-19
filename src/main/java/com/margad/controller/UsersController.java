package com.margad.controller;

import com.margad.model.Users;
import com.margad.service.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/signup")
    public String add(@RequestBody Users user) {
        try {
            usersService.saveUsers(user);
            return "Амжилттай";
        } catch (Exception e) {
            return "Алдаа : " + e.getMessage();
        }
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
}
