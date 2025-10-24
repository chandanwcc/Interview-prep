package com.chandan.interview.practice.test.practice.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorDPMain {
    public static void main(String[] args) {
        Animal monkey = new Monkey();
        Animal lion = new Lion();
        Animal dolphin = new Dolphin();

        List<AnimalVisitor> animalVisitors= new ArrayList<>();
        animalVisitors.add(new Jump());
        animalVisitors.add(new Speak());

        monkey.accepts(animalVisitors);
        lion.accepts(animalVisitors);
        dolphin.accepts(animalVisitors);


    }
}
