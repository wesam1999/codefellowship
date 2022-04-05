package com.example.codefellowship.Repositries;

import com.example.codefellowship.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepositries extends CrudRepository<UserModel,Integer> {
UserModel findByUsername(String Username);
}
