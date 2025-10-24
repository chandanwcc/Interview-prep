package com.chandan.interview.practice.test.practice.practice.visitor.exmple2;

interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
