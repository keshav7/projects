package com.projects.airline.sever.wrapper.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.LogExecutionTime;
import com.projects.core.utils.SuccessCodes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/airline/")
@Slf4j
@Api(value = "/", description = "Tracker user APIs")
public class AirlineController {

    @RequestMapping(value = "/", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "create new user", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity AddUser() {
        ClientResponse clientResponse = new ClientResponse(SuccessCodes.OK);
//        try {v
//            clientResponse = userManagerService.addUser(createUserRequest);
//        } catch (TrackerException e) {
//            log.error("TrackerException in  getLoadExpectationForUnloading", e);
//            clientResponse = ResourceUtils.setClientErrorResponse(e);
//        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }
}
