package com.projects.core.datatypes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projects.core.datatypes.enumInterfaces.Errors;
import com.projects.core.datatypes.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    private int errorStatusCode;
    private int errorInternalStatusCode;
    private String errorReasonCode;
    private String errorDescription;
    private List<ErrorResponse> errorStack = new ArrayList<>();
    private Map<String, Object> additionalData;


    public ErrorResponse(ServiceException se) {
        this.errorStatusCode = se.getErrorStatusCode();
        this.errorReasonCode = se.getErrorReasonCode();
        this.errorDescription = se.getErrorDescription();
        this.errorInternalStatusCode = se.getErrorInternalStatusCode();
        if (se.getAdditionalData() != null) {
            this.additionalData = se.getAdditionalData();
        }

        if (!CollectionUtils.isEmpty(se.getExceptionsStack())) {
            for (ServiceException serviceException : se.getExceptionsStack()) {
                ErrorResponse errorResponse = new ErrorResponse();
                if (serviceException.getAdditionalData() != null) {
                    errorResponse.setAdditionalData(serviceException.getAdditionalData());
                }
                errorResponse.setErrorDescription(serviceException.getErrorDescription());
                errorResponse.setErrorInternalStatusCode(serviceException.getErrorInternalStatusCode());
                errorResponse.setErrorReasonCode(serviceException.getErrorReasonCode());
                errorResponse.setErrorStatusCode(serviceException.getErrorStatusCode());
                errorStack.add(errorResponse);
            }
        }
    }

    public ErrorResponse(Errors errors) {
        this.errorStatusCode = errors.getStatus().value();
        this.errorReasonCode = errors.getCode();
        this.errorDescription = errors.getDescription();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
    }

    public ErrorResponse(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode, String errorDescription,
                         Map<String, Object> additionalData) {
        this.errorStatusCode = errorStatusCode;
        this.errorInternalStatusCode = errorInternalStatusCode;
        this.errorReasonCode = errorReasonCode;
        this.errorDescription = errorDescription;
        if (additionalData != null) {
            this.additionalData = additionalData;
        }
    }
}
