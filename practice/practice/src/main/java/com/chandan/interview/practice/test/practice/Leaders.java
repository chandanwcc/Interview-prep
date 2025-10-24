package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.Stack;

public class Leaders {

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int max = arr[n - 1];

        ArrayList<Integer> res = new ArrayList<>();

        Stack<Integer> s = new Stack<>();

        res.add(max);

        for (int i = n - 2; i > 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                s.push(max);
            }
        }

        while (!s.isEmpty()){
            res.add(s.pop());
        }

        return res;
    }
}

