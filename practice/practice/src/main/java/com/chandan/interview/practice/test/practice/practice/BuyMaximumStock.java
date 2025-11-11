package com.chandan.interview.practice.test.practice.practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

class PriceIndex implements Comparable<PriceIndex> {
    private int price;
    private int index;

    public PriceIndex(int price, int index) {
        this.price = price;
        this.index = index;
    }

    public PriceIndex() {
    }

    @Override
    public int compareTo(PriceIndex priceIndex) {
        return this.getPrice() - priceIndex.getPrice();
    }

    public int getPrice() {
        return this.price;
    }

    public int getIndex() {
        return this.index;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PriceIndex)) return false;
        final PriceIndex other = (PriceIndex) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPrice() != other.getPrice()) return false;
        if (this.getIndex() != other.getIndex()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PriceIndex;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPrice();
        result = result * PRIME + this.getIndex();
        return result;
    }

    public String toString() {
        return "PriceIndex(price=" + this.getPrice() + ", index=" + this.getIndex() + ")";
    }
}

public class BuyMaximumStock {

    public static void main(String[] args) {
        System.out.println(getMaxBuyUnits(new int[]{10, 7, 19}, 45));
        System.out.println(getMaxBuyUnits(new int[]{7, 10, 4}, 100));

    }

    private static int getMaxBuyUnits(int[] stocks, int capital) {
        PriorityQueue<PriceIndex> maxPQ = new PriorityQueue<>();
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(stocks).forEach(el -> maxPQ.offer(new PriceIndex(el, counter.getAndIncrement())));

        int totalUnts = 0;
        while (!maxPQ.isEmpty()) {
            PriceIndex priceIndex = maxPQ.poll();
            int current = Math.min(priceIndex.getIndex(), capital / priceIndex.getPrice());
            totalUnts += current;
            capital -= current * priceIndex.getPrice();
        }
        return totalUnts;
    }
}
