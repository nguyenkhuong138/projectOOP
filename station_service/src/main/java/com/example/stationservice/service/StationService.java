package com.example.stationservice.service;

import com.example.stationservice.model.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    private List<Station> stations = new ArrayList<>();

    public StationService() {

        stations.add(new Station(1, "Station A", 10.776, 106.700, 5));
        stations.add(new Station(2, "Station B", 10.758, 106.680, 2));
        stations.add(new Station(3, "Station C", 10.780, 106.690, 0));
    }

    public List<Station> getStations() {
        return stations;
    }

    public Station findNearest(double lat, double lng) {
        Station nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Station s : stations) {
            double d = Math.sqrt(Math.pow(lat - s.getLatitude(), 2) + Math.pow(lng - s.getLongitude(), 2));
            if (d < minDistance) {
                minDistance = d;
                nearest = s;
            }
        }
        return nearest;
    }

    public Station findById(int id) {
        return stations.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }
}
