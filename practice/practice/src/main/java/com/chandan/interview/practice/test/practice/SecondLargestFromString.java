package com.chandan.interview.practice.test.practice;

public class SecondLargestFromString {

    public static void main(String[] args) {
        System.out.println(getSecondLargest("sjhtz8344"));
    }

    private static int getSecondLargest(String str) {

        char[] arr = str.toCharArray();

        int larg = Integer.MIN_VALUE;
        int scndLarge = Integer.MIN_VALUE;

        for (char c : arr) {

            if (isDigit(c)) {
                int current = Character.getNumericValue(c);
                if (current > larg) {
                    scndLarge = larg;
                    larg =  current;
                } else if (current > scndLarge) {
                    scndLarge = current;
                }
            }
        }
        return scndLarge;
    }

    public static final boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

}
