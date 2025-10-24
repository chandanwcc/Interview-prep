package com.chandan.interview.practice.test.practice.practice;

public class CoinChangeNumberOfWays {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins)); // Output: 4
    }

    private static int change(int amount, int[] coins) {
        int []dp = new int[amount+1];

        dp[0] = 1;

        for(int coin : coins){
            for(int i = coin ; i<= amount ; i++){
                dp[i]+=dp[i-coin];
            }
        }

        return dp[amount];
    }
}
