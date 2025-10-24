package com.chandan.interview.practice.test.practice;

public class PalendromeCheck {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();

        int i =0, j= arr.length-1;

        while(i <= j){
            if(!isAlphaNumeric(arr[i])){
                i++;
                continue;
            }else if(!isAlphaNumeric(arr[j])){
                j--;
                continue;
            }else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {

        return ('a'<=c && c<='z') ||  ('A'<=c && c<='Z') || ('0' <=c && c <='9');
    }

    public static void main(String[] args) {
        PalendromeCheck p = new PalendromeCheck();

        System.out.println(p.isPalindrome("Was it a car or a cat I saw?"));
    }
}
