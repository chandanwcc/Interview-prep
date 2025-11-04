package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

    public static void main(String[] args) {
        String input = "racecariscar";
        String[] wordDict = {"racecar", "race", "car", "is"};
        System.out.println(printAllPossibleWays(input, wordDict));
    }

    private static List<String> printAllPossibleWays(String input, String[] wordDict) {

        Set<String> dict = new HashSet<>(List.of(wordDict));
        int n = input.length();

        List<String>[] dp = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }

        dp[0].add("");

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = input.substring(j, i);
                if (dict.contains(sub)) {
                    for (String sen : dp[j]) {
                        dp[i].add((sen + " " + sub).trim());
                    }
                }

            }
        }
        return dp[n];
    }
}
