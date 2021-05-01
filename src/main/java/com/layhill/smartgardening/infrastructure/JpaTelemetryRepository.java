package com.layhill.smartgardening.infrastructure;

import com.layhill.smartgardening.domain.Telemetry;
import com.layhill.smartgardening.domain.TelemetryRepository;
import io.micronaut.context.annotation.Executable;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.hibernate.annotations.GenericGenerator;

import javax.inject.Singleton;
import javax.persistence.GeneratedValue;
import java.util.Optional;

@Singleton
@Repository
public interface JpaTelemetryRepository extends TelemetryRepository, CrudRepository<Telemetry, String> {

    @Override
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    String nextId();

    @Executable
    @Override
    void add(Telemetry telemetry);

    @Executable
    @Override
    Optional<Telemetry> findById(String id);



}
