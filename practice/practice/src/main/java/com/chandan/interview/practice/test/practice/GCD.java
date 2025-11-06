package com.chandan.interview.practice.test.practice;

public class GCD {

    public static void main(String[] args) {

        String input = "4.50";

        System.out.println(getIrreducibleFraction(input));



    }

    private static String getIrreducibleFraction(String input) {
        if(!input.contains(".")){
            throw new RuntimeException("Not Possible");
        }

        String bf = input.substring(0, input.indexOf("."));
        String af = input.substring(input.indexOf(".")+1);

        int numerator = Integer.parseInt(bf+af);
        int denom = (int) Math.pow(10,af.length());

        int gcd = getGCD(numerator, denom);

        return numerator/gcd + "/" +denom/gcd;
    }

    private static int getGCD(int a, int b) {

        if(b==0){
            return Math.abs(a);
        }
        return getGCD(b, a%b);
    }
}
