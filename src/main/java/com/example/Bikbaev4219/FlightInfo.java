package com.example.Bikbaev4219;

public class FlightInfo {
    private int id;
    private String from;
    private String to;
    private String gate;

    // constructor
    public FlightInfo(int id, String from, String to, String gate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.gate = gate;
    }

    // getters and setters
    public  int getId() {
        return this.id;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String getGate() {
        return  this.gate;
    }
}