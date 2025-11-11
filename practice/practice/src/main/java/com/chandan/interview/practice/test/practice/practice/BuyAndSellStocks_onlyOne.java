package com.chandan.interview.practice.test.practice.practice;

public class BuyAndSellStocks_onlyOne {

    public int maxProfit(int[] prices) {

        int buy =prices[0];
        int maxProfit =0;
        for(int price : prices){
            if(price<buy){
                buy=price;
            }else{
                maxProfit = Math.max(maxProfit, price-buy);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        BuyAndSellStocks_onlyOne b = new BuyAndSellStocks_onlyOne();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
