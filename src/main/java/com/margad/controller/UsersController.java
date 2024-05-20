package com.margad.controller;

import com.margad.model.Users;
import com.margad.scheme.LoginResponse;
import com.margad.scheme.ResponseScheme;
import com.margad.scheme.UsersScheme;
import com.margad.service.Users.UsersService;
import com.margad.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/signup")
    public ResponseScheme signup(@RequestBody UsersScheme scheme) {
        try {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            String dateTime = ft.format(dNow);
            Users user = new Users();
            user.setUserID(dateTime);
            user.setUserName(scheme.getUserName());
            user.setFirstName(scheme.getFirstName());
            user.setLastName(scheme.getLastName());
            user.setEmail(scheme.getEmail());
            user.setUserCreatedDate(dateTime);

            // Salt and Password generated
            String salt = PasswordUtils.getSalt(10);
            user.setSalt(salt);
            user.setPassword(PasswordUtils.generateSecurePassword(scheme.getPassword() , salt));

            System.out.println(scheme);
            //User account create
            usersService.saveUsers(user);
            return ResponseScheme.getInstance(true , "successAccountCreated");
        } catch (Exception e) {
            return ResponseScheme.getInstance(false, e.getMessage());
        }
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UsersScheme scheme) {
        try {
            System.out.println("scheme : " + scheme.getUserName());
            System.out.println("scheme : " + scheme.getPassword());
            List<Users> userList = new ArrayList<>();
            userList = usersService.getAllUsers();
            for(Users user : userList){
                if(scheme.getUserName().equals(user.getUserName())){
                    if(PasswordUtils.verifyUserPassword(scheme.getPassword() , user.getPassword() , user.getSalt())){
                        String salt = PasswordUtils.getSalt(10);
                        String token = PasswordUtils.generateSecurePassword(user.getUserID() + user.getPassword() , salt);
                        user.setToken(token);
                        usersService.saveUsers(user);
                        return new LoginResponse(true, "passwordCorrected" , token);
                    }
                    return  new LoginResponse(false , "passwordInCorrect");
                }
            }
            throw new Exception("Username or password inCorrected");
        } catch (Exception e) {
            return new LoginResponse(false , e.getMessage());
        }
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
}
