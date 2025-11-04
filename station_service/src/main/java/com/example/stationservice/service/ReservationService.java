package com.example.stationservice.service;

import com.example.stationservice.model.Reservation;
import com.example.stationservice.model.Station;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    private int nextId = 1;

    private final StationService stationService;

    public ReservationService(StationService stationService) {
        this.stationService = stationService;
    }

    public Reservation createReservation(int stationId, String driverName, LocalDateTime time) {
        Station station = stationService.findById(stationId);
        if (station == null) return null;
        if (station.getAvailableBatteries() == 0) return null;

        station.reduceBattery();

        Reservation reservation = new Reservation(nextId++, stationId, driverName, time);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
