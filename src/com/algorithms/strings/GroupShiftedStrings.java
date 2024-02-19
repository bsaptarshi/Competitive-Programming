package com.algorithms.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
 *
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */

public class GroupShiftedStrings {
    private Map<String, List<String>> findGroupShiftedStrings(String[] strs) {
        if (null == strs || strs.length == 0) {
            return new HashMap<>();
        }
        
        Arrays.sort(strs);
        
        final Map<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            final char c = str.charAt(0);
            final int diff = c - 'a';
            final String normStr = findCanonicalString(str, diff);
            if (groups.containsKey(normStr)) {
                groups.get(normStr).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groups.put(normStr, newGroup);
            }
        }
        
        return groups;
    }
    
    private String findCanonicalString(final String str, final int k) {
        final StringBuilder newstr = new StringBuilder();
        for (char c : str.toCharArray()) {
            int shiftedChar = (c - k + 26) % 26;
            newstr.append(shiftedChar);
        }
        
        return newstr.toString();
    }
    
    private void printGroupShiftedStrings(final Map<String, List<String>> groups) {
        if (null == groups) {
            return;
        }
        
        System.out.println("Printing Groups of Strings...");
        
        for (String key : groups.keySet()) {
            System.out.println(groups.get(key).toString());
        }
    }
    
    public static void main(String[] args) {
        GroupShiftedStrings obj = new GroupShiftedStrings();
        // "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"
        // "abc", "xyz", "pqr", "cfi", "lor", "ab", "xy", "ij"
        String[] strs = {"abc", "xyz", "pqr", "cfi", "lor", "ab", "xy", "ij"};
        Map<String, List<String>> groups = obj.findGroupShiftedStrings(strs);
        obj.printGroupShiftedStrings(groups);
    }
}
