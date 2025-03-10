package com.example.CGI.model.entity;

import com.example.CGI.model.enums.SeatClass;
import com.example.CGI.model.enums.SeatFeature;
import com.example.CGI.model.valueobject.Position;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Position position;

    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<SeatFeature> features;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    public Seat() {}

    public Seat(Position position, SeatClass seatClass, Set<SeatFeature> features, boolean isAvailable, Plane plane) {
        this.position = position;
        this.seatClass = seatClass;
        this.features = features;
        this.isAvailable = isAvailable;
        this.plane = plane;
    }

    public Long getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public Set<SeatFeature> getFeatures() {
        return features;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
