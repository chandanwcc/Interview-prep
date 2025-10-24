package com.chandan.interview.practice.test.practice;

public class LIS {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lis(arr));
    }

    private static int lis(int[] arr) {

        int[] dp = new int[arr.length];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);

                }

            }

        }
        return max+1;
    }
}
