package com.chandan.interview.practice.test.practice.practice;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b)->b-a);
        minHeap = new PriorityQueue<>((a, b)->a-b);
    }

    public void addNum(int num) {

        maxHeap.add(num);

        int x = maxHeap.poll();

        minHeap.offer(x);

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }

        return maxHeap.peek();

    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();

        m.addNum(1);
        System.out.println(m.findMedian());

        m.addNum(2);
        System.out.println(m.findMedian());

        m.addNum(3);
        System.out.println(m.findMedian());

        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(8);
        System.out.println(m.findMedian());
        m.addNum(10);
        System.out.println(m.findMedian());



    }

}
