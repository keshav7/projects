package controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.LogExecutionTime;
import domain.Company;
import exception.FCException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import request.OrderRequest;
import service.api.CompanyManagerService;
import service.api.OrderMenuManagerService;
import utils.Constants;
import utils.ResourceUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/company/")
@Slf4j
@Api(value = "/", description = "Company apis")
public class CompanyController {


    @Autowired
    CompanyManagerService companyManagerService;
    @RequestMapping(value = "create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "create company", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity createCompany(
            @RequestHeader(value = Constants.X_REQUESTED_BY)
            @ApiParam(value = Constants.X_REQUESTED_BY) String requestedBy,
            @RequestHeader(value = Constants.X_REQUEST_ID)
            @ApiParam(value = Constants.X_REQUEST_ID) String requestId,
            @RequestBody @ApiParam(value = "create company", required = true)
            @Valid Company company) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = companyManagerService.addCompany(company, requestedBy, requestId);
        } catch (FCException e) {
            log.error("LoadManagerException in  getLoadExpectationForUnloading", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

}
