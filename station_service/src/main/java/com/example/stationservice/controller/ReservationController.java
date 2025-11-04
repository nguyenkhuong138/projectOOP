package com.example.stationservice.controller;

import com.example.stationservice.model.Reservation;
import com.example.stationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Object createReservation(@RequestBody ReservationRequest request) {

        Reservation r = reservationService.createReservation(
                request.stationId,
                request.driverName,
                LocalDateTime.parse(request.time)
        );

        if (r == null) {
            return new Response("failed", "Station not found or no batteries available");
        }

        return r;
    }

    static class ReservationRequest {
        public int stationId;
        public String driverName;
        public String time;
    }

    static class Response {
        public String status;
        public String message;

        public Response(String s, String m) {
            status = s;
            message = m;
        }
    }
}
