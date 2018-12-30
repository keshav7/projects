package com.projects.fc.server.controller;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.LogExecutionTime;
import com.projects.fc.server.core.exception.FCException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projects.fc.server.core.request.MenuItemRequest;
import com.projects.fc.server.service.api.MenuItemManagerService;
import com.projects.fc.server.core.utils.Constants;
import com.projects.fc.server.core.utils.ResourceUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/menu_item/")
@Slf4j
@Api(value = "/", description = "Menu Item apis")
public class MenuItemController {

    @Autowired
    MenuItemManagerService menuItemManagerService;
    @RequestMapping(value = "create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "get load expectations for unloading", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity createMenuItem(
            @RequestHeader(value = Constants.X_REQUESTED_BY)
            @ApiParam(value = Constants.X_REQUESTED_BY) String requestedBy,
            @RequestHeader(value = Constants.X_REQUEST_ID)
            @ApiParam(value = Constants.X_REQUEST_ID) String requestId,
            @RequestBody @ApiParam(value = "receive load unit com.projects.fc.server.core.request", required = true)
            @Valid MenuItemRequest request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = menuItemManagerService.addMenuItem(request, requestedBy, requestId);
        } catch (FCException e) {
            log.error("LoadManagerException in  getLoadExpectationForUnloading", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

}
