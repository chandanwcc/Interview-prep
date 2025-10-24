package com.chandan.interview.practice.test.practice.practice.visitor;

public class Jump implements AnimalVisitor {
    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Monkey jumps 20 feet");
    }

    @Override
    public void visitLion(Lion lion) {
        System.out.println("Lion Jumps 7 feet");
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        System.out.println("Dolphin jumps 10 feet on water");
    }
}
