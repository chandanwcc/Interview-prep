package com.chandan.interview.practice.test.practice.practice;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 12, 15, 26, 38};
        int[] b = {2, 13, 17, 30, 45, 60};

        System.out.println(medianOf2(a, b));
    }

    private static double medianOf2(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        if(n>m){
            return medianOf2(b,a);
        }

        int high = n, low =0;

        while (low < high){
            int mid1 = low +(high-low)/2;
            int mid2 = (n+m+1)/2-mid1;

            int l1 = (mid1 ==0) ? Integer.MIN_VALUE : a[mid1-1];
            int l2 = (mid2 ==0) ? Integer.MIN_VALUE : b[mid2-1];

            int r1 = mid1 == n ? Integer.MAX_VALUE : a[mid1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : b[mid2];

            if(l1 <= r2 && l2 <= r1){

                if((m + n) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
                else{
                    return Math.max(l1, l2);
                }

            }

            if(l1 > r2){
                high = mid1 -1;
            }else{
                low = mid1+1;
            }
        }
        return Double.MAX_VALUE;
    }
}
