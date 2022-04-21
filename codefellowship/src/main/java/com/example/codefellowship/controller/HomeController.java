package com.example.codefellowship.controller;


import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/")
  public String getmain(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("username",auth.getName());
    return "main.html";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView getHome() {
        return new RedirectView("/");
    }


    @GetMapping("/logout")
    public RedirectView getLogoutPage() {
        return new RedirectView("/login");
    }


    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }


    @PostMapping("/signup")
    public String signupUser( @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam int dateOfBirth,
                              @RequestParam String bio
                              ) {
        ApplicationUser applicationUser = new ApplicationUser( username,encoder.encode(password) ,firstName,lastName,dateOfBirth,bio);
        userRepository.save(applicationUser);
        return "login";
    }
@GetMapping("/myprofile")
    public String getmyprofile(Model model){

model.addAttribute("Courses",userRepository.findAll());

        return "myprofile";
}


@GetMapping("/users/{id}")
public String getusersid(Model model,@RequestParam int id){

    model.addAttribute("CoursesOne",userRepository.findById(id));
        return "user";
}

    @Transactional
    @GetMapping("/follow/{id}")
    String showFollowSuccessScreen(@PathVariable("id") int id, Model model) {

        ApplicationUser usertofollow = userRepository.findById(id).orElseThrow();

        ApplicationUser currentLoggedInUser = userRepository.findById(1).orElseThrow();
        currentLoggedInUser.getFollowers().add(usertofollow);

        usertofollow.getFollowing().add(currentLoggedInUser);

        userRepository.save(usertofollow);
        userRepository.save(currentLoggedInUser);

        return "success";
    }
    @GetMapping("/feed")
public String getfeedPage(){





        return "feed";
    }



}
