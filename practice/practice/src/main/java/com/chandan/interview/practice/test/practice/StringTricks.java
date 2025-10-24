package com.chandan.interview.practice.test.practice;

public class StringTricks {


    public static void main(String[] args) {

        String a ="hello";
        String b = "hello";
        String c = new String("hello").intern();
        StringBuilder d = new StringBuilder("hello");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(d));


    }
}
