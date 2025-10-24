package com.chandan.interview.practice.test.practice;

import java.util.LinkedList;
import java.util.Queue;

public class LeaderSelection {

    public static void main(String[] args) {
        System.out.println(electLeader(6,5));
    }

    private static int electLeader(int n, int k) {

        Queue<Integer> leaders = new LinkedList<>();

        for(int i = 1; i<= n; i++){
            leaders.offer(i);
        }

        while(leaders.size() >1){
            
            for(int i=1; i< k ; i++){
                leaders.offer(leaders.poll());
            }
            leaders.poll();
        }

        assert leaders.peek() != null;
        return leaders.peek();
    }
}
