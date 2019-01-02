package com.projects.lc.server.wrapper.service.utils;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.datatypes.dto.ErrorResponse;
import com.projects.lc.server.wrapper.service.exception.LCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class ResourceUtils {

    public static ClientResponse setClientErrorResponse(LCException e) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setSuccess(false);
        ErrorResponse errorResponse = new ErrorResponse(e);
        clientResponse.setErrorResponse(errorResponse);
        clientResponse.setHttpStatus(HttpStatus.valueOf(errorResponse.getErrorStatusCode()));
        return clientResponse;
    }
}
