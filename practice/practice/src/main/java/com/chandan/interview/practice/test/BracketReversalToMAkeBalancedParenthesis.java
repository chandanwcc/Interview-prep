package com.chandan.interview.practice.test;

public class BracketReversalToMAkeBalancedParenthesis {
    public static void main(String[] args) {
        String expr = "}{{}}{{{";
        System.out.println(countMinReversals(expr));
    }

    private static int countMinReversals(String expr) {
        if(expr.length() %2 ==1 )
            return -1;

        int leftBrace =0;
        int rightBrace =0;

        for(int i =0; i< expr.length(); i++){

            char ch = expr.charAt(i);

            if( ch == '{'){
                leftBrace ++;
            }else if(leftBrace ==0){
                rightBrace++;
            }else {
                leftBrace--;
            }

        }

        return (int) (Math.ceil(leftBrace/2.0) + Math.ceil(rightBrace/2.0));
    }
}
