package com.chandan.interview.practice.test.practice;//package org.example.practice;
//
//
//import javafx.util.Pair;
//
//import java.util.Stack;
//
//public class LargestRectangleArea {
//
//    public static int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//
//        Stack<Pair<Integer, Integer>> stack = new Stack<>();
//
//        for (int i = 0; i < heights.length; i++) {
//
//            int start = 0;
//
//            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
//                Pair<Integer, Integer> top = stack.pop();
//                maxArea = Math.max(maxArea, top.getValue() * (i - top.getKey()));
//                start = i;
//            }
//            stack.push(new Pair<>(start, heights[i]));
//        }
//
//        for (Pair<Integer, Integer> pair : stack) {
//            int index = pair.getKey();
//            int height = pair.getValue();
//            maxArea = Math.max(maxArea, height * (heights.length - index));
//
//            return maxArea;
//        }
//        return maxArea;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(new int[]{7, 1, 7, 2, 2, 4}));
//    }
//}
