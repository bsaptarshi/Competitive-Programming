package com.algorithms.strings;

/**
 * Given two version numbers, version1 and version2, compare them.
 * Version numbers consist of one or more revisions joined by a dot '.'.
 * Each revision consists of digits and may contain leading zeros.
 * Every revision contains at least one character.
 * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
 * the next revision being revision 1, and so on.
 * For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal.
 * If a version number does not specify a revision at an index, then treat the revision as 0.
 * For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
 * but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * Example 1:
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 *
 * Example 2:
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: version1 does not specify revision 2, which means it is treated as "0".
 *
 * Example 3:
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
 */
public class CompareVersionNumbers {
    private int compareVersion(String version1, String version2) {
        if ((version1 == null || version1.isBlank())
                || (version2 == null || version2.isBlank())) {
            return 0;
        }
        
        int len1 = version1.length(), len2 = version2.length();
        int m = 0, n = 0;
        
        while (m < len1 || n < len2) {
            int subversion1 = 0, subversion2 = 0;
            
            while (m < len1 && version1.charAt(m) != '.') {
                subversion1 = subversion1*10 + version1.charAt(m++) - '0';
            }
            
            while (n < len2 && version2.charAt(n) != '.') {
                subversion2 = subversion2*10 + version2.charAt(n++) - '0';
            }
            
            if (subversion1 > subversion2) {
                return 1;
            } else if (subversion1 < subversion2) {
                return -1;
            } else {
                m++;
                n++;
            }
        }
        
        return 0;
    }
    
    private int compareVersionWithStringSplit(String version1, String version2) {
        if ((version1 == null || version1.isBlank())
                || (version2 == null || version2.isBlank())) {
            return 0;
        }
        
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int i = 0;
        while (i < s1.length || i < s2.length) {
            int subv1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int subv2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            
            if (subv1 > subv2) {
                return 1;
            } else if (subv1 < subv2) {
                return -1;
            }
            i++;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        String s1 = "1.01", s2 = "1.00.001";
        
        System.out.println("Version comparison via non Split Method = " + obj.compareVersion(s1, s2));
        System.out.println("Version comparison via Split Method = " + obj.compareVersionWithStringSplit(s1, s2));
    }
}
