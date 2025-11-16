package com.chandan.interview.practice.test.practice;

import java.util.HashMap;
import java.util.Objects;

record Indexes(int i, int j){

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Indexes indexes)) return false;
        return i == indexes.i && j == indexes.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

public class PatternMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));        // false
        System.out.println(isMatch("aa", "a*"));       // true
        System.out.println(isMatch("ab", ".*"));       // true
        System.out.println(isMatch("aab", "c*a*b"));   // true
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
    }

    private static boolean isMatch(String str, String pattern) {
        return isMatchUtils(0,0,str, pattern, new HashMap<>());
    }

    private static boolean isMatchUtils(int i, int j, String str, String pattern, HashMap<Indexes, Boolean> memo) {

        Indexes key = new Indexes(i,j);

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(j== pattern.length()){
            return i==str.length();
        }

        boolean firstMatch = (i<str.length() && (str.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='.'));

        boolean ans ;
        if(j+1 < pattern.length() && pattern.charAt(j+1) == '*'){
            ans = isMatchUtils(i,j+2,str,pattern,memo) ||(firstMatch && isMatchUtils(i+1,j,str,pattern,memo));
        }else {
            ans = firstMatch && isMatchUtils(i+1, j+1, str, pattern, memo);
        }

        memo.put(key, ans);

        return ans;
    }
}
