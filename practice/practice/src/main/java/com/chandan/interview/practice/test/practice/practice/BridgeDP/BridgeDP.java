package com.chandan.interview.practice.test.practice.practice.BridgeDP;

public class BridgeDP {

    public static void main(String[] args) {
        Video video = new Youtube(new Resolution8K());
        video.play("Hachi");

        video = new Netflix(new Resolution4K());
        video.play("Black");

        video = new Prime(new ResolutionHD());
        video.play("Panchayat");
    }
}
