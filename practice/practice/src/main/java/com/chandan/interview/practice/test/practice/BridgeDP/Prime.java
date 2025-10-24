package com.chandan.interview.practice.test.practice.BridgeDP;

public class Prime extends Video{

    public Prime(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String movie) {
        videoProcessor.resolution(movie);
    }
}
