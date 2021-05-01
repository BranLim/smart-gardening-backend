package com.layhill.smartgardening.domain;

public class Telemetry {

    private String id;
    private String name;
    private int moistureLevel;

    public Telemetry(String id, String name, int moistureLevel) {
        this.id = id;
        this.name = name;
        this.moistureLevel = moistureLevel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int moistureLevel() {
        return moistureLevel;
    }
}
