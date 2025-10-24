package com.chandan.interview.practice.test.practice.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwapNeeded {

    // Method to find minimum swaps required
    static int minSwaps(int[] a, int[] b) {

        // Store index of elements in 'a'
        Map<Integer, Integer> pos = new HashMap<>();
        int n = a.length;

        // Populate the hashmap with indices
        // of elements in 'a'
        for(int i = 0; i < n; i++) {
            pos.put(a[i], i);
        }

        int swaps = 0;

        // Traverse array 'b' to match it with 'a'
        for(int i = 0; i < n; i++) {

            // If element is not in the correct
            // position, swap it
            if(a[i] != b[i]) {
                int temp = b[i];
                b[i] = b[pos.get(b[i])];
                b[pos.get(temp)] = temp;
                swaps++;

            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        // Define input arrays
        int[] a = {3, 6, 4, 8};
        int[] b = {4, 6, 8, 3};

        // Output the minimum swaps required
        System.out.println(minSwaps(a, b));
    }
}