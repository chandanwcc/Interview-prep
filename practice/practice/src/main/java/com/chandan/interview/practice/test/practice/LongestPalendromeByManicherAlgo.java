package com.chandan.interview.practice.test.practice;

public class LongestPalendromeByManicherAlgo {

    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("babad"));
    }

    private static String getLongestPalindrome(String s) {
        StringBuilder t = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            t.append(c).append("#");
        }

        int l = 0, r = 0, maxLen = 0;
        int n = t.length();

        int[] p = new int[n];

        int center = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            p[i] = i < r ? Math.min(r - i, l + (r - i)) : 0;

            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;

                if (maxLength < p[i]) {
                    maxLength = p[i];
                    center = i;
                }
            }
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        int index = (center - maxLength) / 2;

        return s.substring(index, index + maxLength);
    }

    private static String getLongestPalindrome2(String s) {
        StringBuilder t = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            t.append(c).append("#");
        }

        int l = 0, r = 0, maxLen = 0;
        int n = t.length();

        int[] p = new int[n];

        int center = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            p[i] = i < r ? Math.min(r - i, l + (r - i)) : 0;

            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;

                if (maxLength < p[i]) {
                    maxLength = p[i];
                    center = i;
                }
            }
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        int index = (center - maxLength) / 2;

        return s.substring(index, index + maxLength);
    }

}
