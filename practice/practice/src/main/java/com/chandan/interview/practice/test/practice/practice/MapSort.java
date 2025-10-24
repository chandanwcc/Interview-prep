package com.chandan.interview.practice.test.practice.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort {


    public static void main(String[] args) {
        Map<Integer, String > map = new HashMap<>();

        map.put(1, "sdr");
        map.put(5, "tre");
        map.put(3, "abc");
        map.put(6, "rrt");
        map.put(2, "oiu");
        map.put(4, "iut");
        map.put(8, "tty");
        map.put(7, "ert");

        System.out.println(map);

        Map<Integer, String > sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));

        System.out.println(sorted);

    }

}
