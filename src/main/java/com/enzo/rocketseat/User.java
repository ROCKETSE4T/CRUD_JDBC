package com.enzo.rocketseat;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @CurrentTimestamp()
    private LocalDateTime created_at;

    protected User(){}

    public User(Long id, String name, String email, LocalDateTime created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreated_at() {
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
