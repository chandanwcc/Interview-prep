package com.chandan.interview.practice.test.practice;//package org.example.practice;
import java.util.Arrays;
import java.util.Stack;
public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, n);

        for(int i =0 ;i< n; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();

        for(int i =0 ;i< n; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                nextSmaller[stack.pop()] = i;
            }

            stack.push(i);
        }


        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea, (nextSmaller[i]-prevSmaller[i]-1)*heights[i]);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{60, 20, 50, 40, 10, 50, 60}));
    }
}
