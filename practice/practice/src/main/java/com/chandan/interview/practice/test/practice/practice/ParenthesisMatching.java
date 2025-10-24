package com.chandan.interview.practice.test.practice.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisMatching {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> closeOpen = new HashMap<>();
        closeOpen.put(')','(');
        closeOpen.put('}','{');
        closeOpen.put(']','[');


        for(Character c : s.toCharArray()){

            if(closeOpen.containsKey(c) && !stack.isEmpty() && stack.peek() == closeOpen.get(c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
