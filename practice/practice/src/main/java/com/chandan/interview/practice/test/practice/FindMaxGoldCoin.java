package com.chandan.interview.practice.test.practice;

public class FindMaxGoldCoin {

    public static void main(String[] args) {

        //start from bottom left and destination top right, can move only up and right.
        int[][] grid = {{0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}};

        System.out.println(findMaxGold(grid));
    }

    private static int findMaxGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];



        for(int i = rows-1; i>=0; i--){

            for(int j =0; j<cols; j++ ){

                int down = i+1 >=rows ? 0 : dp[i+1][j];
                int left = j-1 < 0 ? 0 : dp[i][j-1];

                dp[i][j] = grid[i][j] + Math.max(down, left);
            }

        }

        return dp[0][cols-1];
    }
}
