package com.chandan.interview.practice.test.practice;

import java.util.*;


public class FindMaxchildRoot {


    // Recursive DFS to count all nodes reachable from this root
    public static int countNodes(int root, Map<Integer, List<Integer>> adj) {
        int count = 1; // count this node itself
        List<Integer> children = adj.getOrDefault(root, new ArrayList<>());

        for (int child : children) {
            count += countNodes(child, adj);
        }
        return count;
    }

    public static void main(String[] args) {
        List<int[]> childToParent = Arrays.asList(
                new int[]{8, 4},
                new int[]{9, 4},
                new int[]{1, 4},
                new int[]{10, 4},
                new int[]{5, 20},
                new int[]{7, 3},
                new int[]{2, 3},
                new int[]{6, 7}
        );

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Build adjacency list (parent -> list of children)
        for (int[] pair : childToParent) {
            int child = pair[0];
            int parent = pair[1];

            adj.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);

            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            inDegree.putIfAbsent(parent, 0);
        }

        // Find all roots (nodes with indegree 0)
        List<Integer> roots = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                roots.add(entry.getKey());
            }
        }

        // For each root, count total nodes in its subtree using DFS
        for (int root : roots) {
            int count = countNodes(root, adj);
            System.out.println("Root: " + root + " Nodes Count: " + count);
        }
    }

}
