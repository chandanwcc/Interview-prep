package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralOderMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] steps = {matrix[0].length, matrix.length - 1};

        int r = 0, c = -1, d = 0;
        while (steps[d % 2] > 0) {
            for (int i = 0; i < steps[d % 2]; i++) {
                r += directions[d][0];
                c += directions[d][1];
                res.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOderMatrix spiralOderMatrix = new SpiralOderMatrix();
        List<Integer> res = spiralOderMatrix.spiralOrder(matrix);
        System.out.println(res);
    }

}
