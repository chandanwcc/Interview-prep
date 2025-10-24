package com.chandan.interview.practice.test.practice;

public class MaxPathAllDirections {

    public static int maxSum = 0;
    public static final int []row = new int[]{1,0};
    public static final int []col = new int[]{0,1};


    public static void main(String[] args) {
        int[][] mat = {
                {5, 3, 2, 1},
                {1, 2, 10, 2},
                {4, 3, 1, 3}
        };

        findMaxPath(mat);

        System.out.println("Maximum Path Sum (All Directions): " + maxSum);
    }

    private static void findMaxPath(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int curSum =0;

        boolean [][]visited = new boolean[m][n];

        maxPathSumUtils(mat, 0, 0, curSum, visited);
    }

    private static void maxPathSumUtils(int[][] mat, int i, int j, int curSum, boolean[][] visited) {

        int m = mat.length;
        int n = mat[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j])
            return;

        curSum+=mat[i][j];

        if(i == m-1 && j==n-1){
            maxSum = Math.max(curSum, maxSum);
            return;
        }

        visited[i][j] = true;

        for (int k : row) {
            maxPathSumUtils(mat, i + k, j + k, curSum, visited);
        }
        visited[i][j] = false;
    }
}
