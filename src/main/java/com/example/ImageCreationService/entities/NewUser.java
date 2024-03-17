package com.example.ImageCreationService.entities;

import jakarta.persistence.*;

@Entity
public class NewUser {
    @Id
/*
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
*/
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
       //     generator = "user_sequence"
    )
    private Long id;
    String username;
    String password;

    public NewUser() {
    }

    public NewUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
