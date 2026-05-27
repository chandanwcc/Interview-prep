package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10}};
        int[][] res = mergeIntervals(intervals);
        System.out.println(Arrays.stream(res).toList());
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int[] curr = intervals[0];

        List<int[]> res = new ArrayList<>();

        for(int i = 1; i< intervals.length; i++){


            if(curr[1] >= intervals[i][0]){
                curr[1] = intervals[i][1];
            }else {
                res.add(curr);
                curr= intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
}
