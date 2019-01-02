package com.projects.lc.server.wrapper.service;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import com.projects.lc.server.wrapper.service.exception.LCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class LCManagerServiceImpl implements LCManagerService {
    @Override
    public ClientResponse longestSubStringWithoutRepeatingCharacters(String inputStr) throws LCException {
        ClientResponse clientResponse = new ClientResponse();

        char[] characters = inputStr.toCharArray();
        HashMap<Character, Integer> hash= new HashMap<>();
        Integer start = 0;
        Integer end = 0;
        for(int i = 0;i < characters.length;i++) {
            if(!hash.containsKey(characters[i])) {
                hash.put(characters[i], i);
            }
            else {
                start = hash.get(characters[i]) + 1;
            }
            end = i;
        }
        Map<String, Object> responseData = new HashMap();
        responseData.put("answer", inputStr.substring(start, end));
        clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
        return clientResponse;
    }
}
