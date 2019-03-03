package com.projects.lc.server.wrapper.service;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
<<<<<<< HEAD
import com.projects.lc.server.wrapper.dto.HotelBookingTime;
import com.projects.lc.server.wrapper.dto.Matrix;
=======
>>>>>>> 86a6f5df5f5fff8a75ac390504bca6b77433b66b
import com.projects.lc.server.wrapper.service.exception.LCException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SourceType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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


    public ClientResponse removeDuplicates(int[] nums) throws LCException{
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<String, Object> responseData = new HashMap();
        responseData.put("input", nums);
        if(list.size() == 0) {
            responseData.put("output", 0);
            return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
        }
        if(list.size() == 1) {
            responseData.put("output", 1);
            return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
        }

        int len = 1;
        int temp;
        int start = 1;
        int currentVal = list.get(0);
        while(start < list.size()) {
            if(list.get(start) != currentVal) {
                temp = list.get(len);
                list.set(len, list.get(start));
                list.set(start, temp);
                currentVal = list.get(len);
                len++;
            }
            start++;
        }

        responseData.put("output", len);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }






    @Override
    public ClientResponse nextPermute(int[] num) {
        Map<String, Object> responseData = new HashMap();
        responseData.put("input", num);
        Boolean found = false;
        for(int i = num.length - 2; i >= 0; i--) {
            for(int j = num.length -1;j > i;j--) {
                if(num[j] > num[i]) {
                    swap(num, i , j);
                    Arrays.sort(num, i+1, num.length);
                    found = true;
                }
                if(found) {
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        if(!found) {
            Arrays.sort(num, 0, num.length);
        }
        responseData.put("output", num);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }




    private void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

    }

//    public List<String> subStringConcatWords(String str, List<String> words) {
//        int i, j;
//        HashMap<Integer, List<Integer>> mapWords = new HashMap<>();
//        for(j = 0;j < mapWords.size();j++) {
//            List<Integer> indices = new ArrayList<>();
//            String word = words.get(j);
//            for (i = 0; i < str.length(); i++) {
//                if(str.indexOf(word, i) != -1) {
//                    indices.add(str.indexOf(word, i));
//                }
//            }
//            mapWords.put(j, indices);
//        }
//
//
//        for(i = 0; i < words.size(); i++) {
//           List<Integer> map = mapWords.get(j);
//           Map<Integer, Boolean> travMap = new HashMap<>();
//           travMap.put(i, true);
//           for(Integer ind : map) {
//               Integer len = words.get(ind).length();
//               Integer size = ind + len;
//               for(int k = 0; k < words.size(); k ++) {
//                   if(travMap.containsKey(k) && !travMap.get(k)) {
//                       List<Integer> vals = mapWords.get(k);
//                       if(vals.contains(size)) {
//
//                       }
//                   }
//               }
//           }
//
//         }
//
//    }
//
//
//    private void fetchResultSubStr(HashMap<Integer, Integer> memo, HashMap<Integer, Boolean> foundMap, Integer count, Integer reqd, List<Integer> indices) {
//
//        if(memo.containsKey(reqd) && !foundMap.get(memo.get(reqd))) {
//            count++;
//            indices.add(reqd);
//            memo.put()
//            fetchResultSubStr(memo, );
//        }
//
//    }







    private ListNode reverseK(ListNode start, int k) {

        int totalCount = getTotalCount(start);
        ListNode first = start;
        ListNode last = null;
        ListNode ptr = start;
        int i = 0;
        while (i < totalCount/k) {

            last = reverse(ptr, k);
            if(first == start) {
                start = last;
            }
            ptr = ptr.next;
            i = i + k;
        }
        return start;
    }

    private int getTotalCount(ListNode start) {
        ListNode ptr = start;
        int count = 0;
        while (ptr.next != null) {
            count++;
        }
        return count;
    }

    private ListNode reverse(ListNode start, int k) {
        ListNode ln1 = start;
        ListNode ln2 = start.next;
        ListNode temp = null;

        int count = 1;
        while (count < k) {
            temp = ln2.next;
            ln2.next = ln1;
            ln1 = ln2;
            ln2 = temp;
        }
        start.next = ln2;
        return ln1;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
    }



    @Override
    public ClientResponse nDigitSSum(int[] input) throws LCException {
        List<String> resultList = new ArrayList<>();
        List<List<Integer>> memo = new ArrayList<>();

        nsPermutes(0, input[0], input[1], 0, "", resultList);


        Map<String, Object> responseData = new HashMap();
        responseData.put("output", resultList);
        responseData.put("count", resultList.size());
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }

    private void nsPermutes(int index, int n, int s, int prevSum, String result, List<String> resultList) {
        System.out.println(index);
        if (index >= n) {
            return;
        }
        if (index == (n - 1)) {
            if ((s - prevSum) <= 9) {
                resultList.add(result + String.valueOf(s - prevSum));
                System.out.println(result + String.valueOf(s - prevSum));
                return;
            }
        }
        int start = 0;
        if (index == 0) {
            start = 1;
        }
        for (int i = start; i <= 9; i++) {
            if ((prevSum + i) <= s) {
                nsPermutes(index + 1, n , s, prevSum + i, result + String.valueOf(i), resultList);
            }
        }
    }

    @Override
    public ClientResponse N3ColorBoard(int[] input) throws LCException {

        HashMap<String, Integer> memo = new HashMap<>();
        int ways = colorBoard(0, 0, 3, input[0], memo, -1);


        Map<String, Object> responseData = new HashMap();
        responseData.put("output", ways);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);

    }

    private int colorBoard(int i, int j, int rows, int columns, HashMap<String, Integer> memo, int prevColor) {

        if (i >= rows || j>= columns) {
            return 0;
        }
        int ways = 1;

        for (int k = 0; k < 4; k++) {
            if (k != prevColor) {
                if (memo.containsKey("i" + "j" + "k")) {
                    return memo.get("i" + "j" + "k");
                }
                ways = ways + colorBoard(i + 1, j, rows, columns, memo, k);
                ways = ways + colorBoard(i, j + 1, rows, columns, memo, k);
            }
        }
        return ways;
    }

    @Override
    public ClientResponse CoinsInLine(List<Integer> input) throws LCException {
        Map<String, Object> responseData = new HashMap();
        responseData.put("output", inLineCoinsMaxValue(input, 0, 0, 0));
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }

    private int inLineCoinsMaxValue(List<Integer> input, int index, int prevSum, int count) throws LCException {
        if (index >= input.size()) {
            return -1;
        }
        int l1 = inLineCoinsMaxValue(input, index + 1, prevSum, count);
        int l2 = -1;
        if (count + 1 == input.size()/2) {
            l2 = prevSum + input.get(index);
        } else if (count + index < input.size()/2) {
            l2 = inLineCoinsMaxValue(input, index + 1, prevSum + input.get(index), count++);
        }
        return Math.max(l1, l2);
    }

    @Override
    public ClientResponse RepeatsAndMissingNumber(List<Integer> input) throws LCException {

        int repeat = -1;
        int missing = -1;
        for (Integer num : input) {
            if (input.get(num - 1) < 0) {
                repeat = num;
            }
            input.set(num - 1, input.get(num - 1) * -1);
        }

        for (int i = 0; i < input.size(); i++) {
            if (i + 1 != repeat && input.get(i) > 0) {
                missing = i + 1;
            }
        }
        System.out.println(input);

        Map<String, Object> responseData = new HashMap();
        responseData.put("repeat", repeat);
        responseData.put("missing", missing);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }

    @Override
    public ClientResponse flipInSequence(List<Integer> input) throws LCException {
        int fStart = -1;
        int fEnd = -1;
        int fCount = 0;
        int start = 0;
        int end = 0;
        int count = 0;


        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 0) {
                count++;
            }
            else {
                count--;
            }
            if (count > 0 && count > fCount) {
                fStart = start;
                fEnd = i;
                fCount = count;
            }
            else {
                count = 0;
                start = i + 1;
            }
        }
        Map<String, Object> responseData = new HashMap();
        responseData.put("start", fStart);
        responseData.put("end", fEnd);
        responseData.put("count", fCount);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }


    @Override
    public ClientResponse hotelBookingTime(List<Integer> arrival, List<Integer> departure, int k) throws LCException {
        int activeBookingsCount = 0;
        Boolean possible = true;
        List<HotelBookingTime> hotelBookingTimes = new ArrayList<>();
        for (Integer arr : arrival) {
            hotelBookingTimes.add(HotelBookingTime.builder().arrival(true).time(arr).build());
        }
        for (Integer dep : departure) {
            hotelBookingTimes.add(HotelBookingTime.builder().arrival(false).time(dep).build());
        }
        Collections.sort(hotelBookingTimes, new Comparator<HotelBookingTime>(){
            public int compare(HotelBookingTime o1, HotelBookingTime o2){
                return o1.getTime() - o2.getTime();
            }
        });
        for (HotelBookingTime hotelBookingTime : hotelBookingTimes) {

            if (!hotelBookingTime.getArrival()) {
                activeBookingsCount--;
            }
            else {
                activeBookingsCount++;
            }

            if (activeBookingsCount > k) {
                possible = false;
            }
        }
        System.out.println(hotelBookingTimes);
        Map<String, Object> responseData = new HashMap();
        responseData.put("possible", possible);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }

    @Override
    public ClientResponse firstMissigPositiveInteger(List<Integer> input) throws LCException {

        int missing = -1;
        for (int i = 0; i< input.size(); i++) {
            if (input.get(i) >=0 && input.get(i) < input.size()) {
                int temp = input.get(i);
                input.set(i, input.get(input.get(i) - 1));
                input.set(input.get(i) - 1, temp);
            }
        }

        for (int j = 0; j < input.size(); j++) {
            if (input.get(j) != j + 1) {
                missing = j + 1;
                break;
            }
        }

        Map<String, Object> responseData = new HashMap();
        responseData.put("possible", missing);
        return new ClientResponse(SuccessCodes.OK, HttpStatus.OK, responseData);
    }
}