package com.example.codefellowship.Repository;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends  JpaRepository<Post,Integer>  {
}
