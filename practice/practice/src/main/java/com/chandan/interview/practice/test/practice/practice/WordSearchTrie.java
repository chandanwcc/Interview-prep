package com.chandan.interview.practice.test.practice.practice;//package interview.practice;
//
//import java.util.*;
//
//class TrieNode{
//    Map<Character, TrieNode> children;
//    boolean isWord;
//
//    public TrieNode() {
//
//        children = new HashMap<>();
//        isWord = false;
//    }
//
//    public void addWord(String word){
//
//        TrieNode trieNode = this;
//        for(char c : word.toCharArray()){
//            trieNode.children.putIfAbsent(c, new TrieNode());
//            trieNode = trieNode.children.get(c);
//        }
//        trieNode.isWord = true;
//    }
//}
//
//
//
//public class WordSearchTrie {
//
//    public Set<String> res = new HashSet<>();
//    int ROWS = 0;
//    int COLS = 0;
//    boolean[][] visited;
//
//    public List<String> findWords(char[][] board, String[] words) {
//
//        TrieNode trieNode = new TrieNode();
//        ROWS = board.length;
//        COLS = board[0].length;
//
//        Arrays.stream(words).forEach(trieNode::addWord);
//
//        visited = new boolean[ROWS][COLS];
//
//        for(int i =0; i< ROWS; i++){
//            for(int j =0; j< COLS; j++){
//                dfs(i, j, board, trieNode, "");
//            }
//        }
//        return new ArrayList<>(res);
//    }
//
//    private void dfs(int row, int col, char[][] board, TrieNode trieNode, String word) {
//
//        if(row < 0 || col <0 || row >= ROWS || col >= COLS || !trieNode.children.containsKey(c) || visited[row][col]){
//            return;
//        }
//
//        visited[row][col] = true;
//
//        trieNode = trieNode.children.get(c);
//        word = word+ board[r][c];
//
//        if(trieNode.isWord){
//            res.add(word);
//        }
//
//
//        visited[row][col] = false;
//
//        dfs(row+1, col, board, trieNode, word );
//        dfs(row, col+1, board, trieNode, word );
//        dfs(row-1, col, board, trieNode, word );
//        dfs(row, col-1, board, trieNode, word );
//    }
//
//    public static void main(String[] args) {
//        WordSearchTrie w = new WordSearchTrie();
//
//        Character[][] board = board = [
//  ["a","b","c","d"],
//  ["s","a","a","t"],
//  ["a","c","k","e"],
//  ["a","c","d","n"]
//];
//
//        w.findWords()
//    }
//}
