package com.chandan.interview.practice.test.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximulElementsFromSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0, right = 0;

        int n = nums.length;

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[n - k + 1];

        while (right < n) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.removeLast();
            }

            deque.addLast(right);

            if (left > deque.peekFirst()) {
                deque.removeFirst();
            }

            if (right + 1 >= k) {
                res[left] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
