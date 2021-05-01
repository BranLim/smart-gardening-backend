package com.layhill.smartgardening.domain;

public interface TelemetryRepository {

    void add(Telemetry telemetry);

    String nextId();

    Telemetry findById(String id);
}
