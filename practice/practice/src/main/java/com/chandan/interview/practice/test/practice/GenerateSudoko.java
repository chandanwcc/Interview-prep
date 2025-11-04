package com.chandan.interview.practice.test.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateSudoko {

    public static final int gridSize = 9;
    public static final int boxSize = 3;
    public static final Random random = new Random();

    public static void main(String[] args) {

        int[][] sudoko = new int[gridSize][gridSize];
        generateSudoko(sudoko, 0, 0);

        System.out.println(isValid(sudoko) ? "valid" : "invalid");

        for (int[] arr : sudoko) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        }

        generatePuzzle(sudoko, 40);
        System.out.println();

        for (int[] arr : sudoko) {
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void generatePuzzle(int[][] sudoko, int count) {
        int removed = 0;
        while (removed < count) {
            int row = random.nextInt(9) + 1;
            int col = random.nextInt(9) + 1;
            if (sudoko[row][col] != 0) {
                sudoko[row][col] = 0;
                removed++;
            }
        }
    }

    private static boolean isValid(int[][] sudoko) {


        for (int i = 0; i < gridSize; i++) {

            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            Set<Integer> subGrid = new HashSet<>();

            int element = 0;

            for (int j = 0; j < gridSize; j++) {

                element = sudoko[i][j];

                if (element != 0) {
                    if (rows.contains(element)) {
                        return false;
                    }
                    rows.add(element);
                }

                element = sudoko[j][i];

                if (element != 0) {
                    if (cols.contains(element)) {
                        return false;
                    }
                    cols.add(element);
                }

                int ri = boxSize * (i / boxSize);
                int ci = boxSize * (i % boxSize);

                element = sudoko[j / 3 + ri][j % 3 + ci];

                if (element != 0) {
                    if (subGrid.contains(element)) {
                        return false;
                    }
                    subGrid.add(element);
                }

            }

        }
        return true;
    }

    private static boolean generateSudoko(int[][] sudoko, int row, int col) {

        if (row == gridSize) {
            return true;
        }

        int nextRow = col == gridSize - 1 ? row + 1 : row;
        int nextCol = (col + 1) % gridSize;

        for (int i = 0; i < gridSize; i++) {
            int val = random.nextInt(9) + 1;

            if (isSafe(val, row, col, sudoko)) {
                sudoko[row][col] = val;
                if (generateSudoko(sudoko, nextRow, nextCol)) {
                    return true;
                }
                sudoko[row][col] = 0;
            }

        }
        return false;
    }

    private static boolean isSafe(int value, int row, int col, int[][] sudoko) {

        for (int i = 0; i < gridSize; i++) {
            if (sudoko[row][i] == value || sudoko[i][col] == value)
                return false;
        }

        int br = (row / boxSize) * boxSize;
        int gc = (col / boxSize) * boxSize;

        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (sudoko[i + br][j + gc] == value)
                    return false;
            }
        }
        return true;
    }
}
