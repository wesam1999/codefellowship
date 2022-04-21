package com.example.codefellowship.Models;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String body;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToMany(mappedBy = "userPost")
    public Set<ApplicationUser> createdAt;


    public Post() {
    }

    public Post(String body) {
        this.body = body;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<ApplicationUser> getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Set<ApplicationUser> createdAt) {
        this.createdAt = createdAt;
    }
}
