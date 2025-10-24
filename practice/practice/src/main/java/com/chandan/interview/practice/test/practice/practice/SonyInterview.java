package com.chandan.interview.practice.test.practice.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Temperature {
    String day;
    int temp;

    public Temperature(String day, int temp) {
        this.day = day;
        this.temp = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Temperature that)) return false;
        return temp == that.temp && Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, temp);
    }
}

public class SonyInterview {

    public static void main(String[] args) {

        List<Temperature> tempList = new ArrayList<>();

        tempList.add(new Temperature("Monday", 20));
        tempList.add(new Temperature("Tuesday", 16));
        tempList.add(new Temperature("Wednesday", -5));
        tempList.add(new Temperature("Thursday", 10));
        tempList.add(new Temperature("Friday", 40));
        tempList.add(new Temperature("Saturday", 50));
        tempList.add(new Temperature("Sunday", 10));

        int index = getTempFluctuateIndex(tempList);
        if(index ==1){
            System.out.println("No temp fall");
        }
        else {
            System.out.println(tempList.get(index-1).day+ "  "+ tempList.get(index).day);
        }
    }

    private static int getTempFluctuateIndex(List<Temperature> tempList) {

        int minRes = Integer.MAX_VALUE;
        int index = -1;

        for(int i =1; i< tempList.size(); i++){

            int res =  tempList.get(i).temp - tempList.get(i-1).temp;

            if(res < minRes){
                minRes = res;
                index = i;
            }

        }
        return index;
    }

}
