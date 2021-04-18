package com.layhill.smartgardening;

import com.layhill.smartgardening.interfaces.dto.TelemetryDTO;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.micronaut.http.HttpRequest.POST;
import static org.assertj.core.api.Assertions.assertThat;
import javax.inject.Inject;

@MicronautTest
public class SmartGardeningBackendTest {

    @Inject
    EmbeddedApplication<?> application;


    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

}
