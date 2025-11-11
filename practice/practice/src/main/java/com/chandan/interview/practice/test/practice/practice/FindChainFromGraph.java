package com.chandan.interview.practice.test.practice.practice;

import java.util.*;
import java.util.stream.Collectors;


public class FindChainFromGraph {
    public static void main(String[] args) {

        List<int[]> pairs = Arrays.asList(
                new int[]{5, 1},
                new int[]{4, 5},
                new int[]{9, 4},
                new int[]{11, 9}
        );

        List<int[]> result = chainPairs(pairs);
        result.forEach(p -> System.out.print("(" + p[0] + "," + p[1] + ") "));

    }

    private static List<int[]> chainPairs(List<int[]> pairs) {

        Map<Integer,Integer> indegreeMap = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int[] arr : pairs){
            int start = arr[0];
            int end = arr[1];

            indegreeMap.putIfAbsent(start,0);
            indegreeMap.put(end,indegreeMap.getOrDefault(end,0)+1);

            map.put(start,end);
        }

        List<Map.Entry<Integer, Integer>> startPoint = indegreeMap.entrySet().stream().filter(x->x.getValue().equals(0)).toList();
        if(startPoint.size() != 1){
            throw new RuntimeException("Invalid");
        }

        int s = startPoint.get(0).getKey();

        List<int[]> res = new ArrayList<>();

        while (map.get(s) != null){
            int e = map.get(s);
            int[] a = new int[]{s,e};

            res.add(a);
            s=e;
        }

        return res;

    }
}
