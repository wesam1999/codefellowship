package com.example.codefellowship.Repository;

import com.example.codefellowship.Models.ApplicationUser;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<ApplicationUser,Integer> {

    ApplicationUser findByUsername(String username);

}
