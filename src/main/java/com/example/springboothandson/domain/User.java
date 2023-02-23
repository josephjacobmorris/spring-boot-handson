package com.example.springboothandson.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    private String firstName;
    private String lastName;
    private String address;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
