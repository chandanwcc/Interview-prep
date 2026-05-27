package com.chandan.interview.practice.test.practice;

import java.util.HashSet;
import java.util.Set;


/**
 * Ashish was copying from Rahit in the exam. So, Rahit told him to change the answers a little bit so that the examiner cannot find the fraud. But silly Ashish in the way started to change all the answers that were needed. He shuffled the letters in each word in a way where the maximum number of letters were misplaced.
 * <p>
 * For a given word, find the maximum difference that Ashish can generate between his answer and Rahit’s answer.
 * <p>
 * Suppose Rahit wrote “car” for an answer, Ashish can write “acr” with difference 2, or “arc” with differnece 3.
 * <p>
 * Note That: The letters are all in lowercase.
 * <p>
 * Input Format:
 * <p>
 * First line containing an integer n, number of words.
 * <p>
 * Then, n numbers of lines as the query words.
 * <p>
 * Output:
 * <p>
 * N number of lines with an integer each denoting possible maximum difference.
 * <p>
 * Sample Input:
 * <p>
 * 4
 * <p>
 * abababa
 * <p>
 * bbj
 * <p>
 * kj
 * <p>
 * kk
 * <p>
 * Sample Output:
 * <p>
 * 6
 * <p>
 * 2
 * <p>
 * 2
 * <p>
 * 0
 */
public class CopyCat {

    public static void main(String[] args) {
        System.out.println(findMaximumDiff("car"));
        System.out.println(findMaximumDiff("abababa"));

        System.out.println(findMaximumDiff("bbj"));

        System.out.println(findMaximumDiff("kj"));
        System.out.println(findMaximumDiff("kk"));

        System.out.println(findMaximumDiff2("car"));
        System.out.println(findMaximumDiff2("abababa"));

        System.out.println(findMaximumDiff2("bbj"));

        System.out.println(findMaximumDiff2("kj"));
        System.out.println(findMaximumDiff2("kk"));

        Integer.toString(2,2);


    }

    private static int findMaximumDiff2(String input) {

        int[] countArr = new int[26];

        int max = 0;

        for (char i : input.toCharArray()) {
            int c = ++countArr[i - 'a'];
            max = Math.max(max, c);
        }

        if (max <= input.length() / 2) {
            return input.length();
        }

        return 2 * (input.length() - max);

    }

    private static int findMaximumDiff(String input) {

        Set<String> allPermutation = new HashSet<>();

        generatePermutation(input, allPermutation);

        int res = 0;

        for (String p : allPermutation) {
            int count = 0;
            for (int i = 0; i < p.length(); i++) {
                if (input.charAt(i) != p.charAt(i)) {
                    count++;
                }
            }

            res = Math.max(res, count);
        }

        return res;
    }

    private static void generatePermutation(String input, Set<String> allPermutation) {
        permutaionUtil(input, 0, input.length(), allPermutation);
    }

    private static void permutaionUtil(String input, int start, int end, Set<String> allPermutation) {

        if (start == end - 1) {
            allPermutation.add(input + "");
        }

        for (int i = start; i < end; i++) {
            input = swap(input, i, start);
            permutaionUtil(input, start + 1, end, allPermutation);
            input = swap(input, i, start);
        }

    }

    public static String swap(String input, int a, int b) {
        char[] arr = input.toCharArray();

        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

        return String.valueOf(arr);
    }
}
