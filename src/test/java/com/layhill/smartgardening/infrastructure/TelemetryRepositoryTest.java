package com.layhill.smartgardening.infrastructure;

import com.layhill.smartgardening.domain.Telemetry;
import com.layhill.smartgardening.domain.TelemetryRepository;
import io.micronaut.context.annotation.Primary;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.inject.Inject;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@MicronautTest
public class TelemetryRepositoryTest {

    @Inject
    TelemetryRepository telemetryRepository;

    @Test
    void testAddTelemetryRecord() {

        when(telemetryRepository.nextId()).thenReturn("363b5ee1-27a9-4b77-ab1e-f53a858a2f66");
        String id = telemetryRepository.nextId();
        Telemetry telemetry = new Telemetry(id, "Plant 1", 800);
        telemetryRepository.add(telemetry);
        assertThat(telemetry.getId()).isEqualTo("363b5ee1-27a9-4b77-ab1e-f53a858a2f66");

    }

    @Test
    void testRecordExistsWhenTelemetryAdded() {
        when(telemetryRepository.nextId()).thenReturn("363b5ee1-27a9-4b77-ab1e-f53a858a2f66");
        when(telemetryRepository.findById("363b5ee1-27a9-4b77-ab1e-f53a858a2f66")).thenReturn(new Telemetry("363b5ee1-27a9-4b77-ab1e-f53a858a2f66", "Plant 1", 800));
        String id = telemetryRepository.nextId();
        Telemetry telemetry = new Telemetry(id, "Plant 1", 800);
        telemetryRepository.add(telemetry);
        Telemetry found = telemetryRepository.findById("363b5ee1-27a9-4b77-ab1e-f53a858a2f66");
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Plant 1");
    }

    @Primary
    @MockBean(MockTelemetryRepository.class)
    TelemetryRepository telemetryRepository() {
        return mock(TelemetryRepository.class);
    }
}
