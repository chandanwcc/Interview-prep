package com.chandan.interview.practice.test.practice.practice.DecoratorDP;

public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + "- Extra Milk -";
    }

    @Override
    public Double price() {
        return coffee.price() + 10.0;
    }

    @Override
    public String toString() {
        return String.format("WithMilk { %s, %s} ",description(), price());
    }
}
