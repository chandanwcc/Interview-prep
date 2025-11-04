package com.chandan.interview.practice.test.practice;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trappingRainWaterUnits(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    private static int trappingRainWaterUnits(int[] heights) {

        int left = 0, right=heights.length-1;
        int leftMax = heights[left], rightMax = heights[right];

        int water =0;

        while (left<right){

            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, heights[left]);
                water+=leftMax-heights[left];
            }else {

                right--;
                rightMax = Math.max(rightMax, heights[right]);
                water+=rightMax-heights[right];
            }
        }

        return water;
    }
}
