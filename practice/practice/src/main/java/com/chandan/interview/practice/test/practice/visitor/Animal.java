package com.chandan.interview.practice.test.practice.visitor;

import java.util.List;

public interface Animal {

    void accepts(List<AnimalVisitor> visitor);
}
