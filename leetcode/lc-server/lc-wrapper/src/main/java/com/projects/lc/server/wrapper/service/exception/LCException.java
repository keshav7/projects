package com.projects.lc.server.wrapper.service.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.core.datatypes.dto.ErrorResponse;
import com.projects.core.datatypes.exception.ServiceException;
import com.projects.lc.server.wrapper.service.enums.Errors;
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
public class LCException extends ServiceException {

    public LCException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                       String errorDescription, HttpStatus status) {
        super(errorStatusCode, errorInternalStatusCode, errorReasonCode, errorDescription, status);
    }

    public LCException(Errors errors, Exception e) {
        super(errors, e);
    }


    public LCException(Errors errors) {
        super(errors);
    }

    public LCException(Errors errors, Map<String, Object> additionalData) {
        super(errors, additionalData);
    }

    public LCException(Errors errors, Map<String, Object> additionalData, Exception e) {
        super(errors, additionalData, e);
    }

    public LCException(ErrorResponse errors) {
        super(errors);
    }
}
