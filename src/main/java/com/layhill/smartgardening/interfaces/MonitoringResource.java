package com.layhill.smartgardening.interfaces;

import com.layhill.smartgardening.interfaces.dto.TelemetryDTO;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Body;

@Controller("/api")
public class MonitoringResource {

    @Post("/monitoring")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse telemetry(@Body TelemetryDTO telemetry) {
        return HttpResponse.ok();
    }

}
