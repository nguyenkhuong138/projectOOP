package com.example.stationservice.controller;

import com.example.stationservice.model.Station;
import com.example.stationservice.service.StationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/nearest")
    public Station getNearest(@RequestParam double lat, @RequestParam double lng) {
        return stationService.findNearest(lat, lng);
    }
}
