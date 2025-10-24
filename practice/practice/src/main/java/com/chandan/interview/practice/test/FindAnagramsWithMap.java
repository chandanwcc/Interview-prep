package com.chandan.interview.practice.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramsWithMap {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Count frequency of each character in pattern
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int matchCount = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Check if current char frequency matches pattern
            if (pMap.containsKey(rightChar) &&
                    windowMap.get(rightChar).intValue() == pMap.get(rightChar).intValue()) {
                matchCount++;
            }

            // Shrink the window to size of p
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                if (pMap.containsKey(leftChar) &&
                        windowMap.get(leftChar).intValue() == pMap.get(leftChar).intValue()) {
                    matchCount--;
                }
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
                left++;
            }

            // If matchCount equals unique chars in p, it's an anagram
            if (matchCount == pMap.size()) {
                result.add(left);
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println("Anagram start indices: " + result);
    }
}
