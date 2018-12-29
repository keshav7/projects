package controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.LogExecutionTime;
import exception.FCException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import request.OrderRequest;
import service.api.OrderMenuManagerService;
import utils.Constants;
import utils.ResourceUtils;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Set;

@RestController
@RequestMapping("/order/")
@Slf4j
@Api(value = "/", description = "Order apis")
public class OrderController {

    @Autowired
    OrderMenuManagerService orderMenuManagerService;
    @RequestMapping(value = "create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "get load expectations for unloading", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity createOrder(
            @RequestHeader(value = Constants.X_REQUESTED_BY)
            @ApiParam(value = Constants.X_REQUESTED_BY) String requestedBy,
            @RequestHeader(value = Constants.X_REQUEST_ID)
            @ApiParam(value = Constants.X_REQUEST_ID) String requestId,
            @RequestBody @ApiParam(value = "receive load unit request", required = true)
            @Valid OrderRequest request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = orderMenuManagerService.createOrder(request, requestedBy, requestId);
        } catch (FCException e) {
            log.error("LoadManagerException in  getLoadExpectationForUnloading", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

}
