package com.chandan.interview.practice.test.practice;

import static java.util.Arrays.stream;

public class MergeSort {

    public static void main(String[] args) {
        int[] input = new int[]{5, 3, 2, 1, 4};

        System.out.println(mergeSort(input, 0, input.length - 1));
        stream(input).forEach(x -> System.out.print(x + ","));
    }

    private static int mergeSort(int[] input, int l, int r) {

        int count = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;

            count += mergeSort(input, l, mid);
            count += mergeSort(input, mid + 1, r);
            count += merge(input, l, mid, r);
        }
        return count;

    }

    private static int merge(int[] input, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        int i = l;     // l half
        int j = mid + 1;  // r half
        int k = 0;
        int count=0;

        while (i <= mid && j <= r) {
            if (input[i] <= input[j]) {
                temp[k++] = input[i++];
            } else {
                temp[k++] = input[j++];
                count+=mid-i+1;
            }
        }

        while (i <= mid) temp[k++] = input[i++];
        while (j <= r) temp[k++] = input[j++];

        // copy back
        System.arraycopy(temp, 0, input, l, temp.length);
        return count;
    }
}
