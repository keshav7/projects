package com.projects.airline.server.core.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projects.airline.server.core.enums.FareType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CreateFareDetailsRequest {
    @NotNull
    FareType fareType;
    @NotNull
    Double price;
}
