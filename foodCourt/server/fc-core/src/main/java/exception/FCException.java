package exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.core.datatypes.dto.ErrorResponse;
import com.projects.core.datatypes.exception.ServiceException;
import enums.Errors;
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
public class FCException extends ServiceException {

    public FCException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                            String errorDescription, HttpStatus status) {
        super(errorStatusCode, errorInternalStatusCode, errorReasonCode, errorDescription, status);
    }

    public FCException(Errors errors, Exception e) {
        super(errors, e);
    }


    public FCException(Errors errors) {
        super(errors);
    }

    public FCException(Errors errors, Map<String, Object> additionalData) {
        super(errors, additionalData);
    }

    public FCException(Errors errors, Map<String, Object> additionalData, Exception e) {
        super(errors, additionalData, e);
    }

    public FCException(ErrorResponse errors) {
        super(errors);
    }
}

