package com.layhill.smartgardening.interfaces;

import com.layhill.smartgardening.interfaces.dto.TelemetryDTO;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@MicronautTest
public class MonitoringResourceTest {


    @Inject
    @Client("/")
    private RxHttpClient client;

    @Test
    void testShouldReturn200WhenReceivedValidTelemetry() {
        String telemetry = "{\"plantName\": \"Plant 1\", \"moistureLevel\": 800}";
        HttpRequest<String> request = POST("/api/monitoring", telemetry);
        HttpResponse response = client.toBlocking().exchange(request);
        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    void testShouldReturn400WhenReceivedNoPlantName() {
        String telemetry = "{\"plantName\": \"\", \"moistureLevel\": 800}";
        HttpRequest<String> request = POST("/api/monitoring", telemetry);
        assertThatThrownBy(()->{
            HttpResponse response = client.toBlocking().exchange(request);
        }).isInstanceOf(HttpClientResponseException.class);

    }


}
