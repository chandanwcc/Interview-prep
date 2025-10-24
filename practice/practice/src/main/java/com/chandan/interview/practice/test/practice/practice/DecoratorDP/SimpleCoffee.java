package com.chandan.interview.practice.test.practice.practice.DecoratorDP;

public class SimpleCoffee implements Coffee {
    @Override
    public String description() {
        return "Basic Coffee";
    }

    @Override
    public Double price() {
        return 10.0;
    }

    @Override
    public String toString() {
        return String.format("SimpleCoffee { %s, %s} ",description(), price());
    }
}
