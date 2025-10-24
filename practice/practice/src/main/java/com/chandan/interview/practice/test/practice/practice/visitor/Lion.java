package com.chandan.interview.practice.test.practice.practice.visitor;

import java.util.List;

public class Lion implements Animal {
    @Override
    public void accepts(List<AnimalVisitor> visitors) {
        visitors.forEach(v->v.visitLion(this));
    }
}
