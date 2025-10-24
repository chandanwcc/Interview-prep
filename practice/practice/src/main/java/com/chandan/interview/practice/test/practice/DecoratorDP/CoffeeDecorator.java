package com.chandan.interview.practice.test.practice.DecoratorDP;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String description() {
        return coffee.description();
    }

    @Override
    public Double price() {
        return coffee.price();
    }
}
