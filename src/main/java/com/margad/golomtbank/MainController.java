package com.margad.golomtbank;

import com.margad.model.Users;
import com.margad.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/user")
    public String addUser(@RequestParam String username ,@RequestParam String password){
        try{
            Users user = new Users();
            user.setUserID("10001");
            user.setUserName(username);
            user.setPassword(password);
            usersRepository.insert(user);
            return String.format("Амжилттай ");
        }catch(Exception e){
            return String.format("Алдаа : " + e.getMessage());
        }
    }

}
