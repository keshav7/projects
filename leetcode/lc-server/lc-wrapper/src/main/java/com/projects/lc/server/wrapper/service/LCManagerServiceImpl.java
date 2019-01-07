package com.projects.lc.server.wrapper.service;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import com.projects.lc.server.wrapper.dto.Matrix;
import com.projects.lc.server.wrapper.service.exception.LCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LCManagerServiceImpl implements LCManagerService {
    @Override
    public ClientResponse longestSubStringWithoutRepeatingCharacters(String inputStr) throws LCException {
        ClientResponse clientResponse = new ClientResponse();

        char[] characters = inputStr.toCharArray();
        HashMap<Character, Integer> hash= new HashMap<>();
        Integer start = 0;
        Integer startA = 0;
        Integer end = 0;
        Integer endA = 0;
        Integer len = 0;
        for(int i = 0;i < characters.length;i++) {
            if(!hash.containsKey(characters[i])) {
                hash.put(characters[i], i);
            }
            else {
                if((end - start + 1) > len) {
                    len = end - start + 1;
                    startA = start;
                    endA = end;
                }
                start = hash.get(characters[i]) + 1;
            }
            end = i;
        }
        Map<String, Object> responseData = new HashMap();
        responseData.put("answer", inputStr.substring(startA, endA + 1));
        clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
        return clientResponse;
    }


    /**
     * {
        "input" : "abcdcb"
        }
     */
    @Override
    public ClientResponse longestPalindromeSubstring(String input) throws LCException {


        int n = input.length();
        Map<String, Boolean> matrix = new HashMap<>();

        Integer start = 0;
        Integer end = 0;
        String key;
        for (int i = 0; i < input.length() - 1; i++) {
            key = String.valueOf(i)  + "," + String.valueOf(i + 1);
            if (input.charAt(i) == input.charAt(i + 1)) {
                matrix.put(key,true);
                start = i;
                end = i + 1;
            }
            else {
                matrix.put(key,false);
            }
        }

        for (int k = 3;k < input.length(); k++) {
            for(int j = 0;j <= input.length() - k; j++) {
                key = String.valueOf(j) + "," + String.valueOf(j+k-1);
                String innerKey = String.valueOf(j + 1) + "," + String.valueOf(j + k - 2);
                matrix.put(key, false);
                if(input.charAt(j) == input.charAt(j + k - 1) &&
                        ((k - 2 == 1) || (matrix.get(innerKey)))) {
                    matrix.put(key, true);
                    if(k > end - start + 1) {
                        start = j ;
                        end = j+k-1;
                    }
                }
            }
        }
        ClientResponse clientResponse;
        Map<String, Object> responseData = new HashMap();
        responseData.put("input", input);
        responseData.put("output", input.substring(start, end + 1));
        clientResponse = new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
        return clientResponse;
    }



    /*unique triplets/quadraplets with sum zero*/
    @Override
    public ClientResponse threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(input);
        Set<String> foundTriplets = new HashSet<>();

        for(int i = 0;i<input.size() - 2;i++) {
            int j = i+1;
            int k = input.size() - 1;
            while(j!=k) {
                if((input.get(i) + input.get(j) + input.get(k) == 0) &&
                        !foundTriplets.
                                contains(input.get(i).toString() + "," +
                                        input.get(j).toString() + "," + input.get(k).toString())) {
                    foundTriplets.add(input.get(i).toString() + "," +
                            input.get(j).toString() + "," + input.get(k).toString());
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(input.get(i));
                    triplet.add(input.get(j));
                    triplet.add(input.get(k));
                    output.add(triplet);
                }
                if(input.get(i) +  input.get(j) + input.get(k) < 0) {
                    j++;
                }
                else {
                    k--;
                }

            }
        }

        Map<String, Object> responseData = new HashMap();
        responseData.put("input", input);
        responseData.put("output", output);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }

    @Override
    public ClientResponse validParenthesis(String input) throws LCException {

        Boolean retBool = true;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<input.length();i++) {
            if(isOpenBracketCharacter(input.charAt(i))) {
                stack.add(input.charAt(i));
            }
            else {
                Character openBracketCounter = fetchOpenBracketCounter(input.charAt(i));
                if(openBracketCounter != null && !stack.empty() && stack.peek() == openBracketCounter) {
                    stack.pop();
                }
                else {
                    retBool = false;
                    break;
                }
            }
        }
        if(!stack.empty()) {
            retBool = false;
        }

        Map<String, Object> responseData = new HashMap();
        responseData.put("input", input);
        responseData.put("output", retBool);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }

    private Boolean isOpenBracketCharacter(Character character) {
        if(character == '{' || character == '(' || character == '[') {
            return true;
        }
        return false;
    }

    private Character fetchOpenBracketCounter(Character character) {

        Character retChar = null;
        switch(character) {
            case '}' :
                retChar = '{';
                break;
            case ')' :
                retChar = '(';
                break;
            case ']' :
                retChar = '[';
                break;
            default : break;
        }
        return retChar;
    }
}
