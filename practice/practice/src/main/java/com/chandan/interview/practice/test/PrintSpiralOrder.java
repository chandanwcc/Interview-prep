package com.chandan.interview.practice.test;

import java.util.ArrayList;


public class PrintSpiralOrder {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        ArrayList<Integer> res = spirallyTraverse(mat);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    private static ArrayList<Integer> spirallyTraverse(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        ArrayList<Integer> res = new ArrayList<>();

        int rowBegin = 0, rowEnd = m - 1, colBegin = 0, colEnd = n - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int i = colBegin; i <= colEnd; ++i) {
                res.add(mat[rowBegin][i]);
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; ++i) {
                res.add(mat[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; --i) {
                    res.add(mat[rowEnd][i]);
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; --i) {
                    res.add(mat[i][colBegin]);
                }
                colBegin++;
            }
        }
        return res;
    }
}
