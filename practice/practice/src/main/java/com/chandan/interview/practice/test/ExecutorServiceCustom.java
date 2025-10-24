package com.chandan.interview.practice.test;

import java.util.concurrent.LinkedBlockingQueue;

interface MyExecutorService {

    void execute(Runnable r);
}

class MyExecutors {

    int capacity;

    static MyExecutorService
    myNewFixedThreadPool(int capacity)
    {

        return new MyThreadPool(capacity);
    }
}

class MyThreadPool implements MyExecutorService {

    static int capacity;
    static int currentCapacity;

    static LinkedBlockingQueue<Runnable>
            linkedTaskBlockingQueue;

    // Member variables of this class
    Execution e;

    // Method 1
    public MyThreadPool(int capacity)
    {

        this.capacity = capacity;
        currentCapacity = 0;

        linkedTaskBlockingQueue
                = new LinkedBlockingQueue<Runnable>();

        e = new Execution();
    }

    public void execute(Runnable r)
    {

        linkedTaskBlockingQueue.add(r);

        e.executeMyMethod();
    }
}

class Execution implements Runnable {

    // Method 1 of  this class
    void executeMyMethod()
    {
        if (MyThreadPool.currentCapacity
                < MyThreadPool.capacity) {
            MyThreadPool.currentCapacity++;

            // Creating object of Thread class
            Thread t = new Thread(new Execution());

            // Starting the thread
            t.start();
        }
    }

    // @Override
    public void run()
    {

        // Till it is true
        while (true) {

            if (MyThreadPool.linkedTaskBlockingQueue.size()
                    != 0) {
                MyThreadPool.linkedTaskBlockingQueue.poll()
                        .run();
            }
        }
    }
}

class Mytask implements Runnable {

    // @Override
    public void run()
    {

        try {
            Thread.sleep(1000);
        }

        catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println(
                "Current Thread :-> "
                        + Thread.currentThread().getName());
    }
}

public class ExecutorServiceCustom {
    public static void main(String[] args)
    {
        MyExecutorService service
                = MyExecutors.myNewFixedThreadPool(3);

        for (int i = 0; i < 20; i++) {

            service.execute(new Mytask());
        }

        Runnable runnableTask = null;
    }
}