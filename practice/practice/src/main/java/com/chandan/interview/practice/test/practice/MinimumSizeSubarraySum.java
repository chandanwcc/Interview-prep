package com.chandan.interview.practice.test.practice;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    private static int minSubArrayLen(int target, int[] nums) {

        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }


}
