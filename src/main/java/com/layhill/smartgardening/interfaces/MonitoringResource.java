package com.layhill.smartgardening.interfaces;

import com.layhill.smartgardening.domain.Telemetry;
import com.layhill.smartgardening.domain.TelemetryRepository;
import com.layhill.smartgardening.interfaces.dto.TelemetryDTO;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Body;

import javax.inject.Inject;


@Controller("/api")
public class MonitoringResource {

    @Inject
    private TelemetryRepository telemetryRepository;

    @Post("/monitoring")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse telemetry(@Body TelemetryDTO aTelemetry) {

        if (aTelemetry.getPlantName() == null || StringUtils.isEmpty(aTelemetry.getPlantName())) {
            return HttpResponse.badRequest();
        }

        Telemetry telemetry = new Telemetry(telemetryRepository.nextId(), aTelemetry.getPlantName(), aTelemetry.getMoistureLevel());
        telemetryRepository.add(telemetry);

        return HttpResponse.ok();
    }

}
