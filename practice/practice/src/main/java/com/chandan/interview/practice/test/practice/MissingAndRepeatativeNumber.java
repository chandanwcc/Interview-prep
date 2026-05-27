package com.chandan.interview.practice.test.practice;

public class MissingAndRepeatativeNumber {
    public static void findNumbers(int[] arr) {
        int n = arr.length;

        long sum = 0, sumSq = 0;

        for (int num : arr) {
            sum += num;
            sumSq += (long) num * num;
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSqSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        long diff = expectedSum - sum;           // M - R
        long diffSq = expectedSqSum - sumSq;     // M^2 - R^2

        long sumMR = diffSq / diff;              // M + R

        long missing = (diff + sumMR) / 2;
        long repeating = missing - diff;

        System.out.println("Missing: " + missing);
        System.out.println("Repeating: " + repeating);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 5, 6};
        findNumbers(arr);
    }
}
