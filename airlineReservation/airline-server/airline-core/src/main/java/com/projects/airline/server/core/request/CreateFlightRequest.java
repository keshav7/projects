package com.projects.airline.server.core.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.enums.FlightStatus;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CreateFlightRequest {
    @NotNull
    String airlineCompany;
    @NotNull
    String aircraft;
    @NotNull
    String srcLocation;
    @NotNull
    String destLocation;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    String designArrTimeSrc;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    String designDepTimeSrc;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    String designArrTimeDest;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    String designDepTimeDest;
}
