package com.chandan.interview.practice.test.practice.practice;


public class MedianOf2SortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median: " + findMedianSortedArrays(nums3, nums4));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // ensure nums1 is smaller
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            int maxX = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minX = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];

            int maxY = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minY = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }
}
