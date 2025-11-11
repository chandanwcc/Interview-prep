package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] res = nextLargerElement(arr);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    private static int[] nextLargerElement(int[] nums) {

        int[] arr = new int[nums.length];

        Arrays.fill(arr, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()){
               arr[i]=stack.peek();
            }
            stack.push(i);
        }
        return arr;
    }
}
