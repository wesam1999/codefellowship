package com.example.codefellowship.Controllers;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repositries.ApplicationUserRepositries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationUserController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    ApplicationUserRepositries applicationUserRepositries;
    @GetMapping("/login")
    public String getLoginPage(){


        return "login";
    }
    @GetMapping("/signup")
    public String getSoginPage(){

        return "signup";
    }
@PostMapping()
    public String SonginUser(@RequestParam String username,@RequestParam String password){
    ApplicationUser applicationUser=new ApplicationUser(username,password);

    applicationUserRepositries.save(applicationUser);
        return "login";
}

}
