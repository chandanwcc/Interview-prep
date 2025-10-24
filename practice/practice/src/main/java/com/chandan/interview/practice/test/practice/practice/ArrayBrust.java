package com.chandan.interview.practice.test.practice.practice;

import java.util.*;

public class ArrayBrust {

    public static void main(String[] args) {

        String []arr = new String[]{"a","b","c","c","c","d","e","e"};
        System.out.println(printBrust(new ArrayList<>(Arrays.asList(arr)), 3));
    }

    private static List<String> printBrust(List<String> inputArray, int brustLength) {

        Stack<String > stack = new Stack<>();

        int top= 0;
        stack.push(inputArray.get(0));
        int count =1;

        for(int i=1; i< inputArray.size(); i++){
            String el = inputArray.get(i);
            stack.push(el);

            if(inputArray.get(top).equals(el) ){
                count++;
            }else{
                top++;
                count =1;
            }

            if(count >= brustLength){
                while (count != 0){
                    stack.pop();
                    count--;
                }
                top--;
            }
        }

        List<String> result = new ArrayList<>();

        while (!stack.isEmpty()){
            result.add(stack.peek());
            stack.pop();
        }

        Collections.reverse(result);
        return result;

    }


}
