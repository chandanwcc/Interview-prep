package com.chandan.interview.practice.test.practice;

import java.util.Arrays;
import java.util.Objects;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}


public class TrieWithArray {

    public static final TrieNode root = new TrieNode();

    public void insert(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public int countWordsEqualTo(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                return 0;
            }
            current = current.children[index];
        }
        return current.isEndOfWord ? 1 : 0;
    }


    public long countWordsStartingWith(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                return 0;
            }
            current = current.children[index];
        }
        return countWords(current);
    }

    private long countWords(TrieNode current) {
        return Arrays.stream(current.children).filter(Objects::nonNull).count();
    }

    public void erase(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                return;
            }
            current = current.children[index];
        }
        current.isEndOfWord = false;
    }

    public static void main(String[] args) {
        TrieWithArray trie = new TrieWithArray();

        trie.insert("hello");
        trie.insert("world");
        trie.insert("heggo");
        trie.insert("hekko");

        System.out.println(trie.countWordsEqualTo("hello"));
        System.out.println(trie.countWordsStartingWith("he"));


    }

}
