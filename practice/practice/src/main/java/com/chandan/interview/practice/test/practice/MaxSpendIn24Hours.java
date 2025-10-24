package com.chandan.interview.practice.test.practice;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String userId;
    double amount;
    long timestamp;

    Transaction(String userId, double amount, long timestamp) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

public class MaxSpendIn24Hours {

    public static Map<String, Double> getMaxSpendIn24Hours(List<Transaction> transactions) {
        // Group transactions by userId
        Map<String, List<Transaction>> userTransactions = transactions.stream().collect(Collectors.groupingBy(Transaction::getUserId));
        Map<String, Double> result = new HashMap<>();

        // Process each user's transactions
        for (Map.Entry<String, List<Transaction>> entry : userTransactions.entrySet()) {
            String user = entry.getKey();
            List<Transaction> txns = entry.getValue();

            PriorityQueue<Transaction> pq = new PriorityQueue<>(Comparator.comparing(Transaction::getTimestamp));

            double currentSum = 0;
            double maxSum = 0;

            for (Transaction txn : txns) {
                pq.offer(txn);
                currentSum += txn.amount;

                while (!pq.isEmpty() && txn.timestamp - pq.peek().timestamp > 24) {
                    currentSum -= pq.poll().amount;
                }

                maxSum = Math.max(maxSum, currentSum);
            }

            result.put(user, maxSum);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("A", 10, 1),
                new Transaction("A", 20, 2),
                new Transaction("A", 30, 26),
                new Transaction("A", 90, 40),
                new Transaction("B", 5, 1),
                new Transaction("B", 50, 10)
        );

        Map<String, Double> output = getMaxSpendIn24Hours(transactions);
        output.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
