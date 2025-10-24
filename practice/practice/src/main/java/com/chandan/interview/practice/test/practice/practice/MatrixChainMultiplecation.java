package com.chandan.interview.practice.test.practice.practice;

import java.util.Arrays;

public class MatrixChainMultiplecation {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4 };
        int n= arr.length;

        int dp[][] = new int[n][n];

        for(int []a : dp){
            Arrays.fill(a, -1);
        }

        int res = matrixChain(arr, 1, n-1, dp);

        System.out.println(res);
    }

    private static int matrixChain(int[] arr, int i, int j, int[][] dp) {

        if(i ==j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            dp[i][j] = Math.min(dp[i][j], matrixChain(arr, i, k, dp) + matrixChain(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
}
