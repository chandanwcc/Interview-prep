package com.chandan.interview.practice.test.practice;

import java.util.HashMap;
import java.util.Map;

class Trie {
    Map<Character, Trie> children;
    boolean isEndOfWord;

    public Trie() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class TrieWithMap {

    public static Trie root = new Trie();

    public static void main(String[] args) {
        TrieWithMap trie = new TrieWithMap();

        trie.insert("hello");
        trie.insert("world");
        trie.insert("heggo");
        trie.insert("hekko");

        System.out.println(trie.search("hello"));
        System.out.println(trie.countWordsStartingWith("he"));
    }

    private void insert(String input) {
        Trie root = TrieWithMap.root;
        for(char c : input.toCharArray()){
            root.children.computeIfAbsent(c, k -> new Trie());
            root = root.children.get(c);
        }
        root.isEndOfWord = true;
    }

    private boolean search(String input) {
        Trie current = root;
        for(char c : input.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }

    private long countWordsStartingWith(String key) {

        while (!key.isEmpty()) {
            if (!root.children.containsKey(key.charAt(0))) {
                return 0;
            }
            root = root.children.get(key.charAt(0));
            key = key.substring(1);
        }
        return countWords(root);
    }

    private long countWords(Trie root) {
        return root.children.size();
    }
}
