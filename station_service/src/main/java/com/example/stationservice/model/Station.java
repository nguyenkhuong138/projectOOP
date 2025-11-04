package com.example.stationservice.model;

public class Station {
    private String id;
    private String name;
    private String location;

    public Station() {
        // default constructor
    }

    public Station(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // setters (optional - remove if you want immutable fields)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public int getAvailableBatteries() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableBatteries'");
    }

    public int getAvailableBatteries() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reduceBattery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceBattery'");
    }

    public void reduceBattery() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
