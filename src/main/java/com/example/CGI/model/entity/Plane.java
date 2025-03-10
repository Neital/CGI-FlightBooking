package com.example.CGI.model.entity;

import com.example.CGI.model.enums.SeatClass;
import com.example.CGI.model.valueobject.Position;
import jakarta.persistence.*;
import java.util.Map;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @MapKey(name = "position") // Maps Position to Seat
    private Map<Position, Seat> seats;

    @ElementCollection
    @CollectionTable(name = "seat_prices", joinColumns = @JoinColumn(name = "plane_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "price")
    private Map<SeatClass, Integer> seatPrices;

    public Plane() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Position, Seat> getSeats() {
        return seats;
    }

    public void setSeats(Map<Position, Seat> seats) {
        this.seats = seats;
    }

    public Map<SeatClass, Integer> getSeatPrices() {
        return seatPrices;
    }

    public void setSeatPrices(Map<SeatClass, Integer> seatPrices) {
        this.seatPrices = seatPrices;
    }

    public int getMinSeatPrice() {
        return seatPrices.values().stream().min(Integer::compare).orElse(0);
    }
}
