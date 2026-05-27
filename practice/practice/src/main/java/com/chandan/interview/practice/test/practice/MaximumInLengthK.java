package com.chandan.interview.practice.test.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class MaximumInLengthK {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k-1) {
                res[index++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
