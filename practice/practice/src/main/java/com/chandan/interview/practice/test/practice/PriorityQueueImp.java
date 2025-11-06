package com.chandan.interview.practice.test.practice;


import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueImp {

    public static void main(String[] args) {


        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)-> b-a);
        PriorityQueue<Integer> minPq = new PriorityQueue<>((a,b)-> a-b);

        for(int i =0; i< 10 ; i++){

            Random r = new Random();
            maxPq.offer(r.nextInt(100));
            minPq.offer(r.nextInt(100));


        }

        maxPq.forEach(x-> System.out.print(x+"->"));
        System.out.println();

        minPq.forEach(x-> System.out.print(x+"->"));


    }
}
