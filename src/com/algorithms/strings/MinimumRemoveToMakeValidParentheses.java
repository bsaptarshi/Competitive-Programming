package com.algorithms.strings;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */

public class MinimumRemoveToMakeValidParentheses {
    private String minRemoveToMakeValid(String s) {
        if (null == s || s.isBlank()) {
            return s;
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] invalid = new boolean[s.length()];
        
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            }
            
            if (ch == ')') {
                if (st.isEmpty()) {
                    invalid[i] = true;
                } else {
                    st.pop();
                }
            }
            
            i++;
        }
        
        while (!st.isEmpty()) {
            invalid[st.pop()] = true;
        }
        
        StringBuilder str = new StringBuilder();
        
        for (i = 0; i < s.length(); i++) {
            if (!invalid[i]) {
                str.append(s.charAt(i));
            }
        }
        
        return str.toString();
    }
    
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses obj = new MinimumRemoveToMakeValidParentheses();
        String[] strs = {"lee(t(c)o)de)", "a)b(c)d", "))((", "lee(t(c)(o)de"};
        
        for (String str : strs) {
            System.out.println(str + " -> " + obj.minRemoveToMakeValid(str));
        }
    }
}
