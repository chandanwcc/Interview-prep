package com.chandan.interview.practice.test.practice.BridgeDP;

public class Netflix extends Video {

    public Netflix(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String movie) {
        videoProcessor.resolution(movie);
    }
}
