package com.chandan.interview.practice.test.practice;

// Simplified Java matching engine sketch (single-threaded matcher per instrument)

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

enum Side { BUY, SELL }
enum OrderType { LIMIT, MARKET }

class Order {
    final long orderId;
    final String clientOrderId;
    final Side side;
    final OrderType type;
    final BigDecimal price; // null for market
    long remainingQty;
    final long timestamp;

    Order(long orderId, String clientOrderId, Side side, OrderType type, BigDecimal price, long qty) {
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.side = side;
        this.type = type;
        this.price = price;
        this.remainingQty = qty;
        this.timestamp = System.nanoTime();
    }
}

class PriceLevel {
    final long priceKey; // use price.longValue() scaled, or BigDecimal if needed
    final Deque<Order> orders = new ArrayDeque<>();
    long totalQuantity = 0;

    PriceLevel(long priceKey) { this.priceKey = priceKey; }

    void add(Order o) {
        orders.addLast(o);
        totalQuantity += o.remainingQty;
    }

    void remove(Order o) {
        if (orders.remove(o)) totalQuantity -= o.remainingQty;
    }
}

class OrderBook {
    // Use Long keys for price scaled by a multiplier for performance; for clarity, we'll use BigDecimal comparisons
    final ConcurrentSkipListMap<BigDecimal, PriceLevel> bids =
            new ConcurrentSkipListMap<>(Comparator.reverseOrder());
    final ConcurrentSkipListMap<BigDecimal, PriceLevel> asks =
            new ConcurrentSkipListMap<>();
    final Map<Long, PriceLevel> orderToLevel = new HashMap<>(); // maps orderId -> level (for cancels)
    final AtomicLong nextOrderId = new AtomicLong(1);

    long nextOrderId() { return nextOrderId.getAndIncrement(); }

    // Place limit order (simplified single-threaded safe)
    void placeOrder(Order order, List<String> tradeEvents) {
        if (order.side == Side.BUY) matchAgainst(order, asks, tradeEvents);
        else matchAgainst(order, bids, tradeEvents);

        if (order.remainingQty > 0 && order.type == OrderType.LIMIT) {
            addToBook(order);
        } else {
            // market order unfilled => canceled or rejected
        }
    }

    private void matchAgainst(Order taker, ConcurrentSkipListMap<BigDecimal, PriceLevel> oppositeSide,
                              List<String> tradeEvents) {
        while (taker.remainingQty > 0) {
            Map.Entry<BigDecimal, PriceLevel> best = oppositeSide.firstEntry();
            if (best == null) break;
            BigDecimal bestPrice = best.getKey();
            // For limit, check price crossing
            if (taker.type == OrderType.LIMIT) {
                if ((taker.side == Side.BUY && taker.price.compareTo(bestPrice) < 0) ||
                        (taker.side == Side.SELL && taker.price.compareTo(bestPrice) > 0)) {
                    break; // no price match
                }
            }
            PriceLevel level = best.getValue();
            while (!level.orders.isEmpty() && taker.remainingQty > 0) {
                Order maker = level.orders.peekFirst();
                long executedQty = Math.min(taker.remainingQty, maker.remainingQty);
                // produce trade
                String trade = String.format("TRADE: taker=%d maker=%d price=%s qty=%d",
                        taker.orderId, maker.orderId, bestPrice.toPlainString(), executedQty);
                tradeEvents.add(trade);

                taker.remainingQty -= executedQty;
                maker.remainingQty -= executedQty;
                level.totalQuantity -= executedQty;

                if (maker.remainingQty == 0) level.orders.removeFirst();
                // TODO: emit maker fill event
            }
            if (level.orders.isEmpty()) oppositeSide.remove(bestPrice);
        }
    }

    private void addToBook(Order order) {
        ConcurrentSkipListMap<BigDecimal, PriceLevel> sideMap =
                order.side == Side.BUY ? bids : asks;
        PriceLevel level = sideMap.computeIfAbsent(order.price, p -> new PriceLevel(0));
        level.add(order);
        orderToLevel.put(order.orderId, level);
    }

    boolean cancel(long orderId) {
        PriceLevel level = orderToLevel.remove(orderId);
        if (level == null) return false;
        // find and remove order in level.orders
        Iterator<Order> it = level.orders.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            if (o.orderId == orderId) {
                level.totalQuantity -= o.remainingQty;
                it.remove();
                return true;
            }
        }
        return false;
    }
}

public class SimpleMatcherExample {
    public static void main(String[] args) {
        OrderBook ob = new OrderBook();
        List<String> trades = new ArrayList<>();

        Order o1 = new Order(ob.nextOrderId(), "c1", Side.SELL, OrderType.LIMIT, new BigDecimal("100.5"), 100);
        ob.placeOrder(o1, trades);

        Order o2 = new Order(ob.nextOrderId(), "c2", Side.BUY, OrderType.LIMIT, new BigDecimal("101.0"), 50);
        ob.placeOrder(o2, trades);

        trades.forEach(System.out::println);
        // Expect trade of 50 at price 100.5
    }
}
