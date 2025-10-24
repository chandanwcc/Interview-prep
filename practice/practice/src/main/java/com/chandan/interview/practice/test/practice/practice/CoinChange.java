package com.chandan.interview.practice.test.practice.practice;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(getMinCoinNeeded(new int[]{1,2,5}, 10));
    }

    private static int getMinCoinNeeded(int[] coins, int sum) {

        int[] dp = new int[sum+1];

        Arrays.fill(dp, sum+1);

        dp[0] =0;

        for(int i =1; i<= sum; i++ ){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i - coin]+1);
                }
            }
        }

        return dp[sum] > sum ? -1 : dp[sum];

    }
}
