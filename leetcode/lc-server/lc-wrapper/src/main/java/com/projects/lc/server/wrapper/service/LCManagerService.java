package com.projects.lc.server.wrapper.service;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.lc.server.wrapper.service.exception.LCException;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public interface LCManagerService {
    ClientResponse longestSubStringWithoutRepeatingCharacters(String inputStr) throws LCException;
    ClientResponse longestPalindromeSubstring(String inputStr) throws LCException;
    ClientResponse threeSum(int[] nums) throws LCException;
    ClientResponse validParenthesis(String input) throws LCException;
    ClientResponse removeDuplicates(int[] nums) throws LCException;
    ClientResponse nextPermute(int[] num) throws LCException;
    ClientResponse nDigitSSum(int[] input) throws LCException;
    ClientResponse N3ColorBoard(int[] input) throws LCException;
    ClientResponse CoinsInLine(List<Integer> input) throws LCException;
    ClientResponse RepeatsAndMissingNumber(List<Integer> input) throws LCException;
    ClientResponse flipInSequence(List<Integer> input) throws LCException;
    ClientResponse hotelBookingTime(List<Integer> arrival, List<Integer> departure, int k) throws LCException;
    ClientResponse firstMissigPositiveInteger(List<Integer> input) throws LCException;
}
