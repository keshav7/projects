package com.projects.core.datatypes.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.core.datatypes.dto.ErrorResponse;
import com.projects.core.datatypes.enumInterfaces.Errors;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ServiceException extends Exception {

    private int errorStatusCode;
    private int errorInternalStatusCode;
    private String errorReasonCode;
    private String errorDescription;
    private HttpStatus status;
    private Map<String, Object> additionalData;
    private List<ServiceException> exceptionsStack = new ArrayList<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ServiceException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                            String errorDescription, HttpStatus status, Map<String, Object> additionalData) {
        this.errorStatusCode = errorStatusCode;
        this.errorInternalStatusCode = errorInternalStatusCode;
        this.errorReasonCode = errorReasonCode;
        this.errorDescription = errorDescription;
        this.status = status;
        this.additionalData = additionalData;
    }

    public ServiceException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                            String errorDescription, HttpStatus status) {
        this.errorStatusCode = errorStatusCode;
        this.errorInternalStatusCode = errorInternalStatusCode;
        this.errorReasonCode = errorReasonCode;
        this.errorDescription = errorDescription;
        this.status = status;
    }

    public ServiceException(Errors errors, Exception e) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
        this.addSuppressed(e);
        addToExceptionStack(e);
    }

    private void addToExceptionStack(Exception e) {
        try {
            ServiceException se = objectMapper.convertValue(e, new TypeReference<ServiceException>() {
            });
            this.addExceptionsStack(se);
        } catch (Exception se) {
            //do nothing
        }
    }

    public final synchronized void addExceptionsStack(ServiceException se) {

        if (se == null) {
            return;
        }
        exceptionsStack.add(se);
    }

    public ServiceException(Errors errors) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
    }

    public ServiceException(Errors errors, Map<String, Object> additionalData) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
        if (!CollectionUtils.isEmpty(additionalData)) {
            this.additionalData = additionalData;
        }
    }

    public ServiceException(Errors errors, Map<String, Object> additionalData, Exception e) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
        if (!CollectionUtils.isEmpty(additionalData)) {
            this.additionalData = additionalData;
        }
        this.addSuppressed(e);
        addToExceptionStack(e);
    }

    public ServiceException(ErrorResponse errors) {
        this.errorStatusCode = errors.getErrorStatusCode();
        this.errorDescription = errors.getErrorDescription();
        this.errorReasonCode = errors.getErrorReasonCode();
        this.status = HttpStatus.valueOf(errors.getErrorStatusCode() == 0 ? 500 : errors.getErrorStatusCode());
        this.errorInternalStatusCode = errors.getErrorInternalStatusCode();
        if (!CollectionUtils.isEmpty(errors.getAdditionalData())) {
            this.additionalData = errors.getAdditionalData();
        }
    }
}