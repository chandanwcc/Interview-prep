package com.chandan.interview.practice.test.practice.practice;

import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class FirstUniqueCharacter {

    public static int firstUniqueChar(String s) {

        Map<Character, Long> countMap = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        OptionalInt index = s.chars().filter(x -> countMap.get((char) x) == 1).map(y -> s.indexOf((char) y)).findFirst();

        return index.orElseGet(() -> -1);

    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("aabb"));
    }
}
