package com.example.CGI.model.entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport fromAirport;
    @ManyToOne
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport toAirport;
    private LocalDateTime startDate;
    private LocalDateTime arrivalDate;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    public Flight() {
    }

    public Flight(Airport fromAirport, Airport toAirport, LocalDateTime startDate, LocalDateTime arrivalDate, Plane plane) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.startDate = startDate;
        this.arrivalDate = arrivalDate;
        this.plane = plane;
    }

    // Flight time calculation
    public Duration getEstimatedFlightTime() {
        return Duration.between(startDate, arrivalDate);
    }

    public int getMinimumPrice() {
        return plane.getMinSeatPrice();
    }

    // Getters and Setters
}
