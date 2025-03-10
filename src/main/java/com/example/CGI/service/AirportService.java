package com.example.CGI.service;

import com.example.CGI.model.entity.Airport;
import com.example.CGI.repository.AirportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }
}