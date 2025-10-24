package com.chandan.interview.practice.test.practice.customThreadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolCustom {
    private final  int poolSize;
    private final Worker[] worker;
    private BlockingQueue<Task> taskQueue;

    public ThreadPoolCustom(int poolSize){
        this.poolSize = poolSize;
        this.worker=new Worker[poolSize];
        this.taskQueue = new LinkedBlockingQueue<>();

        for(int i =0; i< poolSize; i++){
            worker[i] = new Worker("Worker "+ i, taskQueue);
            worker[i].start();
        }
    }

    public void submit(Task task){
        taskQueue.offer(task);
    }
 }
