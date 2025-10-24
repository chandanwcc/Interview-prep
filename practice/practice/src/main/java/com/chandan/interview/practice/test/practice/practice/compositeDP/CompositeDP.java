package com.chandan.interview.practice.test.practice.practice.compositeDP;

public class CompositeDP {

    public static void main(String[] args) {
        Component hd = new Leaf("HDD", 6000);
        Component mouse = new Leaf("Mouse", 200);
        Component monitor = new Leaf("Monitor", 10000);
        Component ram = new Leaf("RAM", 5000);
        Component cpu = new Leaf("CPU", 11000);

        Composite ph = new Composite("peripheral");
        Composite cabinet = new Composite("cabinet");
        Composite mb = new Composite("motherboard");
        Composite computer = new Composite("computer");

        mb.add(cpu);
        mb.add(ram);

        ph.add(mouse);
        ph.add(monitor);

        cabinet.add(hd);
        cabinet.add(mb);

        computer.add(ph);
        computer.add(cabinet);

        computer.componentDetails();
        System.out.println(computer.cost());

        System.out.println(ph.cost());
        System.out.println(mb.cost());
    }
}
