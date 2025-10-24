package com.chandan.interview.practice.test.practice.BridgeDP;

public class Youtube extends Video{

    public Youtube(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String movie) {
        videoProcessor.resolution(movie);
    }
}
