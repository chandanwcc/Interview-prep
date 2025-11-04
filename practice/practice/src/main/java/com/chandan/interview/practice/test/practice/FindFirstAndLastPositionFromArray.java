package com.chandan.interview.practice.test.practice;

import java.util.Arrays;

public class FindFirstAndLastPositionFromArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = findPos(nums, target, false);
        arr[1] = findPos(nums, target, true);
        return arr;
    }

    private static int findPos(int[] nums, int target, boolean isLast) {
        int l = 0, r = nums.length-1;

        int pos =-1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if(nums[m] > target){
                r= m-1;
            }else if(nums[m] < target){
                l=m+1;
            }else {

                pos=m;
                if(isLast){
                    l=m+1;
                }else {
                    r=m-1;
                }
            }

        }

        return pos;

    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11)));
    }
}
