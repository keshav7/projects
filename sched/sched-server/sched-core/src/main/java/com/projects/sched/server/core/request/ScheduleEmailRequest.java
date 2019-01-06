package com.projects.sched.server.core.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;
import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleEmailRequest {
    @Email
    @NotNull
    private String email;

    @NotNull
    private String subject;

    @NotNull
    private String body;

    @NotNull
    private DateTime dateTime;

}