package com.projects.lc.server.wrapper.controller;


import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.LogExecutionTime;
import com.projects.lc.server.wrapper.request.Input;
import com.projects.lc.server.wrapper.service.LCManagerService;
import com.projects.lc.server.wrapper.service.exception.LCException;
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
    @Metered(name = "longest substring without repeating character", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity longestSubstringWithoutRepeatingCharacters(
            @RequestBody @ApiParam(value = "longest substring without repeating characters", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.longestSubStringWithoutRepeatingCharacters(request.getInput());
        } catch (LCException e) {
            log.error("Exception in finding longest substring without repeating characters", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "longest_palindrome_substring", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "longest palindrome substring", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity longestPalindromeSubstring(
            @RequestBody @ApiParam(value = "longest palindrome substring", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.longestPalindromeSubstring(request.getInput());
        } catch (LCException e) {
            log.error("Exception in finding longest palindrome substring", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }


    @RequestMapping(value = "three_sum", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "three sum", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity threeSum(
            @RequestBody @ApiParam(value = "three sum", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.threeSum(request.getInputIntList());
        } catch (LCException e) {
            log.error("Exception in finding longest palindrome substring", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "valid_parenthesis", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "validate parenthesis", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity validateParenthesis(
            @RequestBody @ApiParam(value = "valid parenthesis", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.validParenthesis(request.getInput());
        } catch (LCException e) {
            log.error("Exception in finding longest palindrome substring", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "remove_duplicates_sorted_list", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "remove duplicates sorted list", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity removeDuplicatesSortedList(
            @RequestBody @ApiParam(value = "remove duplicates sorted list", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.removeDuplicates(request.getInputIntList());
        } catch (LCException e) {
            log.error("Exception in finding longest palindrome substring", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "next_permute", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "next permute", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity nextPermute(
            @RequestBody @ApiParam(value = "next permute", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.nextPermute(request.getInputIntList());
        } catch (LCException e) {
            log.error("Exception in finding longest palindrome substring", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }



}
