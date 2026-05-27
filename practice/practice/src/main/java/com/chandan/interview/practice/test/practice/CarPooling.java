package com.chandan.interview.practice.test.practice;

import java.util.HashMap;
import java.util.Map;

public class CarPooling {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;

        System.out.println(canCompleteTrip(trips, capacity));
    }

    private static boolean canCompleteTrip(int[][] trips, int capacity) {

        Map<Integer, Integer> timeCapacityMap = new HashMap<>();

        for (int[] trip : trips) {
            int pass = trip[0];
            int from = trip[1];
            int to = trip[2];

            timeCapacityMap.compute(from, (k, v) -> v == null ? pass : v + pass);
            timeCapacityMap.compute(to, (k, v) -> v == null ? pass : v - pass);
        }

        int currentPassengerCount = 0;

        for (int res : timeCapacityMap.values()) {
            currentPassengerCount += res;

            if (currentPassengerCount > capacity) {
                return false;
            }
        }
        return true;
    }
}
