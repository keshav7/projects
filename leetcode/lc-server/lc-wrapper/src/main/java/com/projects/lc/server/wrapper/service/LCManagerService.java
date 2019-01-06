package com.projects.lc.server.wrapper.service;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.lc.server.wrapper.service.exception.LCException;

public interface LCManagerService {
    ClientResponse longestSubStringWithoutRepeatingCharacters(String inputStr) throws LCException;
    ClientResponse longestPalindromeSubstring(String inputStr) throws LCException;
}
