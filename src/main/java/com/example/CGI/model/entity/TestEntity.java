package com.example.CGI.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // getters and setters
}