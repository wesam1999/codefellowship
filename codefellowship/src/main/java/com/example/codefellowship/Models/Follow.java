package com.example.codefellowship.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Follow {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private  ApplicationUser fromUser;

    @ManyToOne
    private  ApplicationUser toUser;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
