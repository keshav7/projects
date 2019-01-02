package com.projects.lc.server.wrapper.controller;


import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.LogExecutionTime;
import com.projects.lc.server.wrapper.request.LongestSubstringWithoutRepeatCharatersRequest;
import com.projects.lc.server.wrapper.service.LCManagerService;
import com.projects.lc.server.wrapper.service.exception.LCException;
import com.projects.lc.server.wrapper.service.utils.Constants;
import com.projects.lc.server.wrapper.service.utils.ResourceUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lc/")
@Slf4j
@Api(value = "/", description = "leet code problems apis")
public class LCController {

    @Autowired
    LCManagerService lcManagerService;
    @RequestMapping(value = "add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "create company", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity longestSubstringWithoutRepeatingCharacters(
            @RequestBody @ApiParam(value = "longest substring without repeating characters", required = true)
            @Valid LongestSubstringWithoutRepeatCharatersRequest request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.longestSubStringWithoutRepeatingCharacters(request.getInput());
        } catch (LCException e) {
            log.error("Exception in finding longest substring without repeating characters", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }


}
