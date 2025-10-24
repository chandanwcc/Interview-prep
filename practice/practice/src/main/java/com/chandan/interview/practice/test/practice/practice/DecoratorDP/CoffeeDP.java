package com.chandan.interview.practice.test.practice.practice.DecoratorDP;

public class CoffeeDP {

    public static void main(String[] args) {
        Coffee coffee = new WithSugar(new WithMilk(new WithMilk(new WithSugar(new SimpleCoffee()))));


        System.out.println(coffee.toString());

        Coffee coffee1 = new WithSugar(new WithMilk(new SimpleCoffee()));

        System.out.println(coffee1);

    }
}
