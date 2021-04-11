package com.layhill.smartgardening.interfaces.dto;


import java.io.Serializable;

public class TelemetryDTO implements Serializable {

    private int moistureLevel;
    private String plantName;

    protected TelemetryDTO()
    {

    }

    public TelemetryDTO(String plantName, int moistureLevel) {
        super();
        this.plantName = plantName;
        this.moistureLevel = moistureLevel;
    }

    public String getPlantName() {
        return plantName;
    }

    public int getMoistureLevel() {
        return moistureLevel;
    }
}
