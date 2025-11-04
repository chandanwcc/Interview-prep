package com.chandan.interview.practice.test.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubSequenceWithoutRepeatingCharecter {

    public static void main(String[] args) {
        System.out.println(getLongestSubSequnce("abcabcbbxyzdk"));
    }

    private static String getLongestSubSequnce(String input) {

        int l=0,r=0;

        String res = "";

        Set<Character> charSet = new HashSet<>();

        for(;r<input.length(); r++){

            while (charSet.contains(input.charAt(r))){
                charSet.remove(input.charAt(l));
                l++;
            }
            charSet.add(input.charAt(r));

            res = res.length() <= r-l+1 ? input.substring(l,r+1) : res;

        }
        return res;
    }
}
