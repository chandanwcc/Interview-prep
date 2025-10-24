package com.chandan.interview.practice.test.practice.practice;

import java.util.ArrayList;
import java.util.List;

public class SpecialElemets {

    public static void main(String[] args) {

        List<List<Integer>> input = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();

        row1.add(0, 1);
        row1.add(1, 3);
        row1.add(2, 4);

        input.add(row1);

        List<Integer> row2 = new ArrayList<>();

        row2.add(0, 5);
        row2.add(1, 2);
        row2.add(2, 9);

        input.add(row2);

        List<Integer> row3 = new ArrayList<>();

        row3.add(0, 8);
        row3.add(1, 7);
        row3.add(2, 6);

        input.add(row3);

        System.out.println(input);

        System.out.println(countSpecialElements(input));


    }

    static int countSpecialElements(List<List<Integer>> matrix) {

        int i = 0;
        int j = 0;
        int special = 0;

        for (List<Integer> row : matrix) {
            j = 0;
            for (int x : row) {
                if (i< matrix.size() && j< matrix.get(0).size() && isSpecial(x, i, j, matrix, matrix.size(), matrix.get(0).size())) {
                    special++;
                }
                j++;
            }
            i++;
        }
        return special;
    }

    private static boolean isSpecial(int x, int i, int j, List<List<Integer>> matrix, int ROWS, int CLOS) {

        List<Integer> rowValue = matrix.get(i);
        boolean rowFlag = findSpecialInRow(rowValue).contains(x);
        boolean cloFlag = findSpecialInCol(matrix, j).contains(x);


        return rowFlag || cloFlag;


    }

    private static List<Integer> findSpecialInCol(List<List<Integer>> matrix, int j) {
        List<Integer> res = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (List<Integer> rows : matrix) {
            int val = rows.get(j);
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
            res.add(min);
            res.add(max);
        }

        return res;
    }

    private static List<Integer> findSpecialInRow(List<Integer> rowValue) {

        List<Integer> res = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int x : rowValue) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }

        res.add(min);
        res.add(max);

        return res;

    }
}
