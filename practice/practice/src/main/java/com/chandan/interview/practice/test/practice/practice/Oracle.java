package com.chandan.interview.practice.test.practice.practice;


class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class UserLinkedList{

    private Node head;
    private Node tail;

    public void add(int x){
        Node node = new Node(x);
        if(head == null){
            head = tail = node;
        }else{
           tail.next = node;
           tail = node;
        }
    }

    public void display(){
        Node x = head;
        while (x != null){
            System.out.print(x.data + " -> ");
            x=x.next;
        }
    }

    public void sortLinkedList() {

        Node p1 = head;
        Node p2 = head;

        while (p1 != null) {
            while (p2 != null) {
                if (p1.data > p2.data) {
                    int tmp = p1.data;
                    p1.data = p2.data;
                    p2.data = tmp;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
    }

}


public class Oracle {

    public static void main(String[] args) {

        UserLinkedList u = new UserLinkedList();
        u.add(10);
        u.add(7);
        u.add(18);
        u.add(100);
        u.add(134);
        u.add(90);
        u.add(190);

        u.sortLinkedList();

        u.display();
    }
}
