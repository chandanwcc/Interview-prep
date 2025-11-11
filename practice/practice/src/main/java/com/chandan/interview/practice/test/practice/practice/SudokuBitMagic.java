package com.chandan.interview.practice.test.practice.practice;

public class SudokuBitMagic {
    private static final int SIZE = 9;

    // Masks for rows, columns, and boxes
    private final int[] rowMask = new int[SIZE];
    private final int[] colMask = new int[SIZE];
    private final int[] boxMask = new int[SIZE];

    public boolean solveSudoku(int[][] board) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int num = board[i][j];
                if (num != 0) {
                    int mask = 1 << (num - 1);
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    rowMask[i] |= mask;
                    colMask[j] |= mask;
                    boxMask[boxIndex] |= mask;
                }
            }
        }

        return solve(board, 0, 0);

    }

    private boolean solve(int[][] board, int row, int col) {

        if (row == SIZE) return true;
        if (col == SIZE) return solve(board, row + 1, 0);
        if (board[row][col] != 0) return solve(board, row, col + 1);


        int boxIndex = (row/ 3) * 3 + (col / 3);
        int used = rowMask[row] | colMask[col] | boxMask[boxIndex];

        for (int num = 1; num <= SIZE; num++) {
            int masked = 1 << (num - 1);

            if ((used & masked) == 0) {
                board[row][col] = num;
                rowMask[row] |= masked;
                colMask[col] |= masked;
                boxMask[boxIndex] |= masked;

                if (solve(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = 0;
                rowMask[row] &= ~masked;
                colMask[col] &= ~masked;
                boxMask[boxIndex] &= ~masked;
            }
        }

        return false;
    }


    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuBitMagic solver = new SudokuBitMagic();
        if (solver.solveSudoku(board))
            printBoard(board);
        else
            System.out.println("Invalid input");
    }
}
