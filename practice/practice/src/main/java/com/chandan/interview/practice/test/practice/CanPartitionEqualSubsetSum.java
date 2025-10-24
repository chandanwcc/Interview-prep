package com.chandan.interview.practice.test.practice;

import java.util.Arrays;

public class CanPartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums)); // Output: true
    }

    private static boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if(sum %2 == 1){
            return false;
        }

        boolean []dp = new boolean[sum/2+1];
        dp[0] = true;

        for (int num : nums){
            for(int i = sum/2; i>= num ; i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }

        return dp[dp.length-1];
    }
}
