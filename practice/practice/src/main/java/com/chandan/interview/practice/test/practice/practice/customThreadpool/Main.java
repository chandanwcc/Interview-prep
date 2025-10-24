package com.chandan.interview.practice.test.practice.practice.customThreadpool;

public class Main {

    public static void main(String[] args) {
        ThreadPoolCustom custom = new ThreadPoolCustom(3);

        for(int i =0; i< 10 ; i++){
            custom.submit(new Task(i));
        }
    }
}
