package com.chandan.interview.practice.test.practice.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> ans =
                combinationSum(candidates, target);

        System.out.println(ans);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        generateBackTrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private static void generateBackTrack(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> res) {

        if(target ==0){
            res.add(new ArrayList<>(current));
            return;
        }

        if(target <0 || index >= candidates.length){
            return;
        }

        current.add(candidates[index]);

        generateBackTrack(candidates, target - candidates[index],index, current, res);
        current.remove(current.size()-1);
        generateBackTrack(candidates,target, index+1,current,res);
    }
}
