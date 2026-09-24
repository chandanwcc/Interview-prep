package com.chandan.interview.practice.test;

public class KadanesAlgo {

        public int maxSubArray(int[] nums) {
            int curentSum=nums[0];
            int maxSum = nums[0];

            for(int n:nums){
                curentSum += n;
                if(curentSum < 0){
                    curentSum =0;
                }

                maxSum = Math.max(maxSum, curentSum);
            }

            return maxSum;
        }

    public static void main(String[] args) {
        System.out.println(new KadanesAlgo().maxSubArray(new int[]{-2,1}));
    }
}
