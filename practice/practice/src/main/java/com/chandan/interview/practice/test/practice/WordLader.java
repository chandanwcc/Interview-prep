package com.chandan.interview.practice.test.practice;


import java.util.*;

public class WordLader {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return -1;
        }

        wordList.add(beginWord);

        Map<String, List<String>> nei = new HashMap<>();

        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (endWord.equals(word)) {
                    return res;
                }
                for (int j = 0; j < Objects.requireNonNull(word).length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neighbour : nei.get(pattern)) {
                        if (!visit.contains(neighbour)) {
                            visit.add(neighbour);
                            queue.offer(neighbour);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("bat", "bag", "sag", "dag", "dot"));
        System.out.println(ladderLength("cat", "sag", wordList));
    }
}
