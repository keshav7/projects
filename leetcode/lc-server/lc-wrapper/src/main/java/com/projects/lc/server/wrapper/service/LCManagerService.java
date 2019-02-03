package com.projects.lc.server.wrapper.service;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.lc.server.wrapper.service.exception.LCException;

public interface LCManagerService {
    ClientResponse longestSubStringWithoutRepeatingCharacters(String inputStr) throws LCException;
    ClientResponse longestPalindromeSubstring(String inputStr) throws LCException;
    ClientResponse threeSum(int[] nums) throws LCException;
    ClientResponse validParenthesis(String input) throws LCException;
    ClientResponse removeDuplicates(int[] nums) throws LCException;
    ClientResponse nextPermute(int[] num) throws LCException;
}
