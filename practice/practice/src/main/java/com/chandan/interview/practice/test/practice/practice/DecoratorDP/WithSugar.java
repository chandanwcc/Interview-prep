package com.chandan.interview.practice.test.practice.practice.DecoratorDP;

public class WithSugar extends CoffeeDecorator {
    public WithSugar(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String description() {
        return coffee.description() + "- Extra Sugar -";
    }

    @Override
    public Double price() {
        return coffee.price() + 5.0;
    }

    @Override
    public String toString() {
        return String.format("WithSugar { %s, %s} ",description(), price());
    }
}
