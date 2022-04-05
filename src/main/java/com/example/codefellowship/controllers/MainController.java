package com.example.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String Mainpage(){
        return "main";
    }
    @GetMapping("/myprofile")
    public String myprofile(){


        return "myprofile";
    }
@GetMapping("/users/{id}")
    public String Userid(){


        return "user";
}


}
