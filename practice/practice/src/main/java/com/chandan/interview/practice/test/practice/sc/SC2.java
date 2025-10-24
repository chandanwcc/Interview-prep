package com.chandan.interview.practice.test.practice.sc;


import java.util.Stack;

public class SC2 {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minimum = new Stack<>();
    int min = Integer.MAX_VALUE;


    public void push(int el) {

        if (el < min) {
            min = el;
        }
        stack.push(el);
        minimum.push(min);

    }

    public int min() {
        return minimum.peek();
    }

    public void pop() {
        stack.pop();
        minimum.pop();
    }

    public static void main(String[] args) {

        SC2 sc2 = new SC2();

        sc2.push(10);
        sc2.push(7);
        sc2.push(2);
        sc2.push(5);
        sc2.push(3);

        sc2.pop();

        sc2.pop();
        sc2.pop();

        System.out.println(sc2.min());


    }

}
