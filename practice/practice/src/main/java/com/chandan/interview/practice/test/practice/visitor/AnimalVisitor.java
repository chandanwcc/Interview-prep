package com.chandan.interview.practice.test.practice.visitor;

public interface AnimalVisitor {
    void visitMonkey(Monkey monkey);
    void visitLion(Lion lion);
    void visitDolphin(Dolphin dolphin);
}
