package com.chandan.interview.practice.test.practice.visitor;

import java.util.List;

public class Monkey implements Animal{
    @Override
    public void accepts(List<AnimalVisitor> visitors) {
        visitors.forEach(v->v.visitMonkey(this));
    }
}
