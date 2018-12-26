package com.projects.core.datatypes.enumInterfaces;

import org.springframework.http.HttpStatus;

public interface Errors {

    HttpStatus getStatus();

    String getCode();

    String getDescription();

    int getInternalErrorCode();

}
