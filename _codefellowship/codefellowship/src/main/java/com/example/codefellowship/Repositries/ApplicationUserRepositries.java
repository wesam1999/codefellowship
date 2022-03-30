package com.example.codefellowship.Repositries;

import com.example.codefellowship.Model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepositries extends CrudRepository<ApplicationUser,Integer> {
    ApplicationUser findByUsername(String username);

}
