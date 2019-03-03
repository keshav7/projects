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


    @RequestMapping(value = "n_digit_s_sum", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "N digit numbers with digit sum S, Find out the number of N digit numbers, whose digits on being " +
            "added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself." +
            " i.e. leading zeroes are not allowed.", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity nDigitSSum(
            @RequestBody @ApiParam(value = "n_digit_s_sum", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.nDigitSSum(request.getInputIntList());
        } catch (LCException e) {
            log.error("Exception in finding N digits with S sum", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "n_3_color_board", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "Given a 3Xn board, find the number of ways to color it using at most 4 colors such that no two " +
            "adjacent boxes have same color. Diagonal neighbors are not treated as adjacent boxes. ", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity N3ColorBoard(
            @RequestBody @ApiParam(value = "n_3_color_board", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.N3ColorBoard(request.getInputIntList());
        } catch (LCException e) {
            log.error("Exception in finding N digits with S sum", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "coins_in_line", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "Given a 3Xn board, find the number of ways to color it using at most 4 colors such that no two " +
            "adjacent boxes have same color. Diagonal neighbors are not treated as adjacent boxes. ", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity CoinsInLine(
            @RequestBody @ApiParam(value = "coins_in_line", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.CoinsInLine(request.getIntegerList());
        } catch (LCException e) {
            log.error("Exception in finding max in n coins in line", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "repeat_and_missing", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "You are given a read only array of n integers from 1 to n." +
            "Each integer appears exactly once except A which appears twice and B which is missing." +
            "Return A and B." +
            "Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?" +
            "Note that in your output A should precede B.", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity RepeatsAndMissingNumber(
            @RequestBody @ApiParam(value = "coins_in_line", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.RepeatsAndMissingNumber(request.getIntegerList());
        } catch (LCException e) {
            log.error("Exception in finding max in n coins in line", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "flip_in_seq", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "You are given a binary string(i.e. with characters 0 and 1) S consisting of characters " +
            "S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and " +
            "flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.\n" +
            "Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. " +
            "If you don’t want to perform the operation, return an empty array. Else, return an array consisting of" +
            " two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair" +
            " of L and R.", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity flipInSeq(
            @RequestBody @ApiParam(value = "flip_in_seq", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.flipInSequence(request.getIntegerList());
        } catch (LCException e) {
            log.error("Exception in finding max in n coins in line", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "hotel_booking_time", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "A hotel manager has to process N advance bookings of rooms for the next season. " +
            "His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether " +
            "there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in " +
            "time O(N log N) .", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity hotelBookingTimes(
            @RequestBody @ApiParam(value = "hotel_booking_time", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.hotelBookingTime(request.getIntegerList(), request.getSecondIntegerList(),
                    request.getTarget());
        } catch (LCException e) {
            log.error("Exception in finding max in n coins in line", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

    @RequestMapping(value = "first_missing_positive_int", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Metered(name = "Given an unsorted integer array, find the first missing positive integer. " +
            "Your algorithm should run in O(n) time and use constant space.", absolute = true)
    @LogExecutionTime
    public @ResponseBody
    ResponseEntity firstMissingPositiveInteger(
            @RequestBody @ApiParam(value = "first_missing_positive_int", required = true)
            @Valid Input request) {
        ClientResponse clientResponse = null;
        try {
            clientResponse = lcManagerService.firstMissigPositiveInteger(request.getIntegerList());
        } catch (LCException e) {
            log.error("Exception in finding max in n coins in line", e);
            clientResponse = ResourceUtils.setClientErrorResponse(e);
        }
        return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
    }

}
