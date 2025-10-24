package com.chandan.interview.practice.test.practice.visitor;

import java.util.List;

public class Dolphin implements Animal {
    @Override
    public void accepts(List<AnimalVisitor> visitors) {
        visitors.forEach(v->v.visitDolphin(this));
    }
}
