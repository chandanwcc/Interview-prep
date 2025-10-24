package com.chandan.interview.practice.test.practice.visitor.exmple2;

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        if (cost > 50) {
            System.out.println("Book: " + book.getIsbnNumber() + " has discount applied.");
            cost -= 5;
        }
        System.out.println("Book ISBN: " + book.getIsbnNumber() + " cost = " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        return cost;
    }
}
