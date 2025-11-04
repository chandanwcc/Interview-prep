package com.chandan.interview.practice.test.practice;

public class WordBreak {

    public static void main(String[] args) {
        String s = "ilike";
        String[] dictionary
                = { "like", "i","gfg" }; // Using String array

        System.out.println(
                wordBreak(s, dictionary));
    }

    private static boolean wordBreak(String input, String[] dictionary) {

        int n = input.length();
        boolean []dp = new boolean[n+1];
        dp[0]=true;

        for (int i =1; i<= n; i++){
            for(String w : dictionary){
                int s = i-w.length();
                if(s>=0 && dp[s] && input.substring(s,s+w.length()).equals(w)){
                    dp[i]=true;
                    break;
                }

            }
        }
        return dp[n];
    }
}
