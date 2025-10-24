package com.chandan.interview.practice.test.practice.practice;

public class FindMissingPositiveNumber {

    public static void main(String[] args) {

        int[] input1 = new int[]{1, 2, 0};
        int[] input2 = new int[]{3, 4, -1, 1};
        int[] input3 = new int[]{7, 8, 9, 11, 12};
        int[] input4 = new int[]{1, 2, 3, 4};

        System.out.println(findMissing(input1));
        System.out.println(findMissing(input2));
        System.out.println(findMissing(input3));
        System.out.println(findMissing(input4));

    }

    private static int findMissing(int[] nums) {

        int len = nums.length;
        int i = 0;

        while (i < len) {

            if(nums[i] <= 0 || nums[i] > len){
                i++;
                continue;
            }

            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }

        for (i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private static void swap(int[] inputs, int index1, int index2) {
        int temp = inputs[index1];
        inputs[index1] = inputs[index2];
        inputs[index2] = temp;
    }
}
