package com.chandan.interview.practice.test.practice;

import java.util.HashMap;
import java.util.Map;


public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        int count = t.length();

        int[] minWindow = {0, Integer.MAX_VALUE};
        int startIndex = 0;

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            if (countMap.containsKey(ch) && countMap.get(ch) > 0) {
                count--;
            }
            countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);

            if (count == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (countMap.containsKey(charAtStart) && countMap.get(charAtStart) == 0) {
                        break;
                    }
                    countMap.put(charAtStart, countMap.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                countMap.put(s.charAt(startIndex), countMap.getOrDefault(s.charAt(startIndex), 0) + 1);
                count++;
                startIndex++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        System.out.println(minimumWindowSubString.minWindow("ADOBECODEBANC", "ABC"));
    }
}