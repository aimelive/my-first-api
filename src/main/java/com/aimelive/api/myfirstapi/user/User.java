package com.aimelive.api.myfirstapi.user;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private  String username;
    private  String fullName;
    private LocalDate dob;
    @Column(unique=true)
    private  String email;

    public User() {
    }

    public User(
            Long id,
            String username,
            String fullName,
            LocalDate dob,
            String email) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
    }

    public User(String username, String fullName, LocalDate dob, String email) {
        this.username = username;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
