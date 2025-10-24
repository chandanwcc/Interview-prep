package com.chandan.interview.practice.test.practice;

public class CountSubsetSumOfK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int k = 6;
        System.out.println(countSubsets(nums, k));  // Output: 3
    }

    private static int countSubsets(int[] nums, int sum) {
        int []dp = new int[sum+1];

        dp[0] =1;

        for(int num : nums){

            for(int i = sum ; i>= num ; i--){

                dp[i] += dp[i-num];
            }

        }

        return dp[sum];
    }
}
