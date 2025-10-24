package com.chandan.interview.practice.test.practice.practice.compositeDP;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    String name;
    List<Component> components = new ArrayList<>();

    public void add(Component c) {
        components.add(c);
    }

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void componentDetails() {
        System.out.println(name);
        for (Component c : components)
            c.componentDetails();
    }

    @Override
    public int cost() {
        int price = 0;
        for (Component c : components) {
            price += c.cost();
        }
        return price;
    }
}
