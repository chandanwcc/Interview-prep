package com.chandan.interview.practice.test.practice.practice;

import java.util.Arrays;

public class CoinChangeMinCount {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // Output: 3
    }

    private static int coinChange(int[] coins, int amount) {
        int []dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i= 1; i<= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

//        Arrays.stream(dp).forEach(System.out::print);

        return dp[amount];

    }
}
