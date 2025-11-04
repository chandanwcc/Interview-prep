package com.chandan.interview.practice.test.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface Square {
    int calculate(int x);
}

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        Square square = (x) -> x * x;
        System.out.println(square.calculate(4));

        Predicate<Integer> predicate = x -> x % 2 == 0;

        List<Integer> temp = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6));

        System.out.println(temp.stream().filter(predicate).collect(Collectors.toSet()));

        System.out.println(predicate.test(30));

        Consumer<String> consumer = System.out::println;

        consumer.accept("Hello word");

        BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + "  " + str2);
        biConsumer.accept("hello", "world");

        Supplier<String> supplier = () -> "Return supplier";

        System.out.println(supplier.get());

        Function<Integer, String> function = x->String.valueOf(x)+"hello";

        System.out.println(function.apply(100));

        System.out.println(temp.stream().map(function).collect(Collectors.toSet()));

        BiFunction<Integer, Integer, String> biFunction = (x,y)-> String.valueOf(x+y)+"Hi";

        System.out.println(biFunction.apply(10,20));

        BinaryOperator<Integer> binaryOperator = Integer::sum;

        System.out.println(binaryOperator.apply(2,3));

        UnaryOperator<Integer> unaryOperator = (x)-> x*x;

        System.out.println(unaryOperator.apply(9));



    }
}
