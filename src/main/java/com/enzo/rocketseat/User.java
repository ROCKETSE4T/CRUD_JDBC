package com.enzo.rocketseat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private Long id;
    private String name;
    private String email;
    private Date created_at;

    public User(Long id, String name, String email, Date created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
