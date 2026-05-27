package com.chandan.interview.practice.test.practice;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0, 0, 0, 2, 1, 1, 0, 0, 0, 1, 1, 1,};
        sort012(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + "->"));
    }

    private static void sort012(int[] arr) {

        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        int temp;
        while (j <= k) {
            if (arr[j] == 0) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            } else if (arr[j] == 2) {
                temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                k--;
            } else
                j++;
        }


    }
}
