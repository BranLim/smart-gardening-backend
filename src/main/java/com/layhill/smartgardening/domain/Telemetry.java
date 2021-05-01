package com.layhill.smartgardening.domain;

import io.micronaut.context.annotation.Primary;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name="telemetry")
public class Telemetry {

    @Id
    @NotNull
    private String id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "moistureLevel")
    @Positive
    private int moistureLevel;

    @Column(name = "receivedTime")
    private LocalDate receivedTime;

    protected Telemetry() {
    }

    public Telemetry(String id, String name, int moistureLevel) {
        this.id = id;
        this.name = name;
        this.moistureLevel = moistureLevel;
        receivedTime = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMoistureLevel() {
        return moistureLevel;
    }

    public LocalDate getReceivedTime() {
        return receivedTime;
    }
}
