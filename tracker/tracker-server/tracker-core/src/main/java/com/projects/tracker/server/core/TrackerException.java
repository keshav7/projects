package com.projects.tracker.server.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.core.datatypes.dto.ErrorResponse;
import com.projects.core.datatypes.exception.ServiceException;
import com.projects.tracker.server.core.enums.Errors;
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
public class TrackerException extends ServiceException {

    public TrackerException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                            String errorDescription, HttpStatus status) {
        super(errorStatusCode, errorInternalStatusCode, errorReasonCode, errorDescription, status);
    }

    public TrackerException(Errors errors, Exception e) {
        super(errors, e);
    }


    public TrackerException(Errors errors) {
        super(errors);
    }

    public TrackerException(Errors errors, Map<String, Object> additionalData) {
        super(errors, additionalData);
    }

    public TrackerException(Errors errors, Map<String, Object> additionalData, Exception e) {
        super(errors, additionalData, e);
    }

    public TrackerException(ErrorResponse errors) {
        super(errors);
    }
}

