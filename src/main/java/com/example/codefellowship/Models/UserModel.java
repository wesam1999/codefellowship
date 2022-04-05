package com.example.codefellowship.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UserModel implements UserDetails {
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
@Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private int bio;





    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }



    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }



}
