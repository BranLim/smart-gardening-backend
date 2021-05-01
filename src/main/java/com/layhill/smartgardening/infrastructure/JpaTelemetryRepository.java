package com.layhill.smartgardening.infrastructure;

import com.layhill.smartgardening.domain.Telemetry;
import com.layhill.smartgardening.domain.TelemetryRepository;

import io.micronaut.data.annotation.Repository;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.UUID;

@Repository
@Singleton
public class JpaTelemetryRepository implements TelemetryRepository {

    private UUID idGenerator = UUID.randomUUID();

    @PersistenceContext
    private EntityManager entityManager;


    public JpaTelemetryRepository() {

    }

    @Override
    public void add(Telemetry telemetry) {
        entityManager.persist(telemetry);
    }

    @Override
    public String nextId() {
        return idGenerator.toString();
    }

    @Override
    public Optional<Telemetry> findById(String id) {
        return Optional.ofNullable(entityManager.find(Telemetry.class, id));
    }
}
