package com.chandan.interview.practice.test.practice;//package com.chandan.practice.practice.interview.practice;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//class NodeLevel {
//    int data;
//    int level;
//
//    public NodeLevel(int data, int level) {
//        this.data = data;
//        this.level = level;
//    }
//
//}
//
//public class AllViewOfBinaryTree {
//
//    public static void main(String[] args) {
//        // Create the tree
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.right.left = new Node(4);
//        root.right.left.right = new Node(5);
//
//
//        List<Integer> topView = topView(root);
//
//        List<Integer> bottomView = bottomView(root);
//
//        List<Integer> leftView = leftView(root);
//
//        List<Integer> rightView = rightView(root);
//
//
//        System.out.println("Top View: " + topView);
//
//        System.out.println("Bottom View: " + bottomView);
//
//        System.out.println("left View: " + leftView);
//
//        System.out.println("right View: " + rightView);
//
//
//    }
//
//    private static List<Integer> rightView(Node root) {
//
//        List<Integer> results = new ArrayList<>();
//
//        rightViewUtils(root, 0, results);
//
//        return results;
//    }
//
//
//    private static List<Integer> leftView(Node root) {
//        List<Integer> resultList = new ArrayList<>();
//
//        leftViewUtils(root, 0, resultList);
//
//        return resultList;
//    }
//
//
//    private static List<Integer> bottomView(Node root) {
//        Map<Integer, NodeLevel> hdMap = new TreeMap<>();
//
//        bottomViewUtils(root, 0, 0, hdMap);
//
//        return hdMap.values().stream().map(x -> x.data).collect(Collectors.toList());
//    }
//
//
//    private static List<Integer> topView(Node root) {
//        Map<Integer, NodeLevel> hdMap = new TreeMap<>();
//
//        topViewUtils(root, 0, 0, hdMap);
//
//        return hdMap.values().stream().map(x -> x.data).toList();
//    }
//
//    private static void topViewUtils(Node root, int hd, int level, Map<Integer, NodeLevel> hdMap) {
//        if (root == null) {
//            return;
//        }
//        if (!hdMap.containsKey(hd) || level < hdMap.get(hd).level) {
//            hdMap.put(hd, new NodeLevel(root.data, level));
//        }
//        topViewUtils(root.left, hd - 1, level + 1, hdMap);
//        topViewUtils(root.right, hd + 1, level + 1, hdMap);
//    }
//
//    private static void bottomViewUtils(Node root, int hd, int level, Map<Integer, NodeLevel> hdMap) {
//        if (root == null) {
//            return;
//        }
//        if (!hdMap.containsKey(hd) || level > hdMap.get(hd).level) {
//            hdMap.put(hd, new NodeLevel(root.data, level));
//        }
//        bottomViewUtils(root.left, hd - 1, level + 1, hdMap);
//        bottomViewUtils(root.right, hd + 1, level + 1, hdMap);
//    }
//
//    private static void rightViewUtils(Node root, int level, List<Integer> results) {
//        if (root == null) {
//            return;
//        }
//        if (level == results.size()) {
//            results.add(root.data);
//        }
//        rightViewUtils(root.right, level + 1, results);
//        rightViewUtils(root.left, level + 1, results);
//    }
//
//    private static void leftViewUtils(Node root, int level, List<Integer> resultList) {
//        if (root == null)
//            return;
//        if (level == resultList.size()) {
//            resultList.add(root.data);
//        }
//        leftViewUtils(root.left, level + 1, resultList);
//        leftViewUtils(root.right, level + 1, resultList);
//    }
//
//
//}
