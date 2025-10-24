package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();

        List<int[]> frequency = new ArrayList<>();

        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            frequency.add(new int[]{e.getKey(), e.getValue()});
        }

        List<int[]> sorted = frequency.stream().sorted((a, b) -> b[1] - a[1]).toList();

        int[] res = new int[k];

        for (int i =0; i< k; i++)
            res[i] = sorted.get(i)[0];

        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,1,1,1,2,2,3,3,3};
        int[] arr = topKFrequent(input, 2);

        for (int j : arr) System.out.println(j);
    }
}



