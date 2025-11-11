package com.chandan.interview.practice.test.practice.practice;

public class MinSubArrayLengthTargetSum {
    public static void main(String[] args) {
        System.out.println(getMinArrayLength(new int[]{1, 4, 45, 6, 0, 19}, 51));
    }

    private static int  getMinArrayLength(int[] array, int target) {

        int sum =0;
        int j =0;
        int minLen = Integer.MAX_VALUE;

        for (int i =0; i<array.length; i++){
            sum+=array[i];
            while (sum > target){
                minLen = Math.min(i-j+1, minLen);
                sum -= array[j];
                j++;
            }
        }
        return minLen;
    }
}
