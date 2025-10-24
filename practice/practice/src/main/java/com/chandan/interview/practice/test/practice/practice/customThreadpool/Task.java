package com.chandan.interview.practice.test.practice.practice.customThreadpool;

public class Task implements Runnable {
    private int id;
    public Task(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Task -> " + id + "  " + Thread.currentThread().getName());
    }
}
