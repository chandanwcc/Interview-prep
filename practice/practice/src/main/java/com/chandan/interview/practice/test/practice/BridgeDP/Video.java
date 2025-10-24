package com.chandan.interview.practice.test.practice.BridgeDP;

public abstract class Video {

    public VideoProcessor videoProcessor;

    public Video(VideoProcessor videoProcessor){
        this.videoProcessor = videoProcessor;
    }

    abstract public void play(String movie);
}
