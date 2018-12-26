package com.projects.airline.server.core.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.airline.server.core.enums.Errors;
import com.projects.core.datatypes.dto.ErrorResponse;
import com.projects.core.datatypes.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AirlineException extends ServiceException {

    public AirlineException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                                String errorDescription, HttpStatus status) {
        super(errorStatusCode, errorInternalStatusCode, errorReasonCode, errorDescription, status);
    }

    public AirlineException(Errors errors, Exception e) {
        super(errors, e);
    }


    public AirlineException(Errors errors) {
        super(errors);
    }

    public AirlineException(Errors errors, Map<String, Object> additionalData) {
        super(errors, additionalData);
    }

    public AirlineException(Errors errors, Map<String, Object> additionalData, Exception e) {
        super(errors, additionalData, e);
    }

    public AirlineException(ErrorResponse errors) {
        super(errors);
    }
}
