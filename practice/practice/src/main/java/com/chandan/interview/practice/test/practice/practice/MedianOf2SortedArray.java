//package com.chandan.interview.practice.test.practice.practice;
//
//
//public class MedianOf2SortedArray {
//
//    public static void main(String[] args) {
//            int[] nums1 = {1, 3};
//            int[] nums2 = {2};
//            System.out.println(findMedianSortedArrays(nums1, nums2)); // 2.0
//
//            int[] nums3 = {1, 2};
//            int[] nums4 = {3, 4};
//            System.out.println(findMedianSortedArrays(nums3, nums4)); // 2.5
//    }
//
//    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        if(nums1.length > nums2.length){
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int m = nums1.length;
//        int n = nums2.length;
//
//        int totalLength = m+n;
//
//        int low = 0, high = m-1;
//
//        while (low<=high){
//
//            int pX = (low+high)/2;
//            int pY = (totalLength+1)/2 - pX;
//
//            int maxX = getMax(pX, nums1);
//            int rx = getMin(pX, nums1);
//
//            int lx = getMin(pY, nums1);
//            int rx = getMax(pY, nums1);
//
//            if(){
//
//            }
//
//        }
//
//    }
//
//    private static int getMin(int partation, int[] array) {
//        return partation == 0 ? Integer.MIN_VALUE : array[partation-1];
//    }
//
//    private static int getMax(int partation, int[] array) {
//        return partation == 0 ? Integer.MAX_VALUE : array[partation];
//
//    }
//}
