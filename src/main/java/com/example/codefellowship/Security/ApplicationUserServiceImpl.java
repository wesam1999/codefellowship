package com.example.codefellowship.Security;

import com.example.codefellowship.Repositries.UserRepositries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements UserDetailsService {
@Autowired
    UserRepositries userRepositries;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepositries.findByUsername(username);
    }
}
