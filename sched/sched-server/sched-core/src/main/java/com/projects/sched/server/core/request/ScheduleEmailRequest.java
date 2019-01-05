package com.projects.sched.server.core.request;

import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

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