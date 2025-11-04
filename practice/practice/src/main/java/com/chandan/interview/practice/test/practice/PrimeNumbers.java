package com.chandan.interview.practice.test.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimeNumbers {
    public static void main(String[] args) {
        Arrays.stream(printPrimes(30)).forEach(el->System.out.print(el+ " "));
    }

    private static int[] printPrimes(int number) {

        boolean[] prime = new boolean[number+1];

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for(int i =2; i*i <= number ; i++){
            if(prime[i]){
                for(int j = i*i ; j<= number; j=j+i){
                    prime[j] = false;
                }
            }
        }

       return IntStream.range(0, number+1).filter(i->prime[i]).toArray();

    }
}
