package com.chandan.interview.practice.test.practice.customThreadpool;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread{

    BlockingQueue<Task> taskQueue;
    private String name;


    public Worker(String name, BlockingQueue<Task> taskQueue){
        super(name);
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true){
            try{
                Runnable task = taskQueue.take();
                task.run();
            }catch (Exception e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
