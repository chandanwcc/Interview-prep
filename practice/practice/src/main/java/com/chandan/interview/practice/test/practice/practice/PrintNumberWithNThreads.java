package com.chandan.interview.practice.test.practice.practice;

public class PrintNumberWithNThreads {

    private int number = 1;
    private static final int MAX = 20;

    private final Object lock = new Object();

    public static void main(String[] args) {

        PrintNumberWithNThreads p = new PrintNumberWithNThreads();

        Thread t1 = new Thread(()-> p.printNumbers(3), "Thread-1");
        Thread t2 = new Thread(()-> p.printNumbers(2), "Thread-2");
        Thread t3 = new Thread(()-> p.printNumbers(1), "Thread-3");
        Thread t4 = new Thread(()-> p.printNumbers(0), "Thread-4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public void printNumbers(int threadId) {
        while (true) {
            synchronized (lock) {
                while (number <= MAX && number % 4 != threadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (number > MAX) {
                    lock.notifyAll();
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " -> " + number++);
                lock.notifyAll();
            }
        }
    }
}
