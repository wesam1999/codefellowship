package com.example.codefellowship.controllers;

import com.example.codefellowship.Models.UserModel;
import com.example.codefellowship.Repositries.UserRepositries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepositries applicationUserRepositries;
    @GetMapping("/login")
    public String getLoginPage(){


        return "login.html";
    }
    @GetMapping("/signup")
    public String getSoginPage(){

        return "signup.html";
    }
    @PostMapping("/signup")
    public String SonginUser(@RequestParam String username, @RequestParam String password){
        UserModel applicationUser=new UserModel(username,password);

        applicationUserRepositries.save(applicationUser);
        return "login.html";
    }

}
