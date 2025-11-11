package com.chandan.interview.practice.test.practice.practice;

public class ClimbingKstairs {
    public static void main(String[] args) {
        System.out.println(climbStairsK(4, 3)); // Output: 7
        System.out.println(climbStairsK(5, 2)); // Output: 8
    }

    private static int climbStairsK(int n, int k) {

        int[] dp = new int[n+1];

        dp[0] =1;


        for(int i =1; i<=n; i++){
          for(int j =1; j<=k; j++){
              if(i-j>=0){
                  dp[i]+=dp[i-j];
              }
          }
        }
        return dp[n];
    }
}
