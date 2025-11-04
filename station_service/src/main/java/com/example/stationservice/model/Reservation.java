package com.example.stationservice.model;

import java.time.LocalDateTime;

public class Reservation {

    private int reservationId;
    private int stationId;
    private String driverName;
    private LocalDateTime time;

    public Reservation(int reservationId, int stationId, String driverName, LocalDateTime time) {
        this.reservationId = reservationId;
        this.stationId = stationId;
        this.driverName = driverName;
        this.time = time;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getStationId() {
        return stationId;
    }

    public String getDriverName() {
        return driverName;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
