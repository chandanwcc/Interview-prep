package com.chandan.interview.practice.test.practice.practice.visitor;

public class Speak implements AnimalVisitor {
    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Monkey Shout : Ohh ooo aa");
    }

    @Override
    public void visitLion(Lion lion) {
        System.out.println("Lion roar");
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        System.out.println("Dolhin speak Tok tok");
    }
}
