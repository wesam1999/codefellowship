package com.example.codefellowship.Security;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repositries.ApplicationUserRepositries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements UserDetailsService {
@Autowired
    ApplicationUserRepositries applicationUserRepositries;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepositries.findByUsername(username);
    }
}
