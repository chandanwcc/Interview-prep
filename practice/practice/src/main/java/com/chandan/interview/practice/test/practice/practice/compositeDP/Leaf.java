package com.chandan.interview.practice.test.practice.practice.compositeDP;

public class Leaf implements Component {

    private final String name;
    private final int price;

    @Override
    public void componentDetails() {
        System.out.println(name + "->>" + price );;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public int cost() {
        return price;
    }

    public Leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
