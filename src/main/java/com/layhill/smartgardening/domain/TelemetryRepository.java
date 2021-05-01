package com.layhill.smartgardening.domain;

import java.util.Optional;

public interface TelemetryRepository {

    void add(Telemetry telemetry);

    String nextId();

    Optional<Telemetry> findById(String Id);
}
