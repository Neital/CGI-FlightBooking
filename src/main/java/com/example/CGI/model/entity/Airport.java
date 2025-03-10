package com.example.CGI.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;  // e.g., "JFK", "LHR"
    private String name;  // e.g., "John F. Kennedy International Airport"
    private String city;  // e.g., "New York"
    private String country;  // e.g., "USA"

    public Airport() {}

    public Airport(String code, String name, String city, String country) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    // Getters and Setters
}