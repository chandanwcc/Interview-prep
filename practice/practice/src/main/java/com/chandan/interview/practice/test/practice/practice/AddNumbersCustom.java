package com.chandan.interview.practice.test.practice.practice;

public class AddNumbersCustom {

    public static void main(String[] args) {
        System.out.println(addNum("99","99"));
        System.out.println(addNum("89","58"));
        System.out.println(addNum("78999998","97"));
        System.out.println(addNum("1009","1"));
    }

    private static String addNum(String a, String b) {

        int len = Math.max(a.length(), b.length());
        int  mark = len-1;
        int i, j;
        long[] res = new long[len];
        for(i =a.length()-1, j = b.length()-1; i>= 0 || j >=0; i--,j--){
            int na = i>=0 ? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
            int nb = j >=0 ? Integer.parseInt(String.valueOf(b.charAt(j))) :0 ;
            int sum = na+nb;
            res[mark] = sum;
            mark --;
        }

        StringBuilder r = new StringBuilder();
        for (long re : res) {
            r.append(re);
        }

        return r.toString();

    }
}
