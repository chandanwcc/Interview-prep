package com.chandan.interview.practice.test.practice.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class MergeKSortedLinkedList {
    public static void main(String[] args) {
        List<ListNode> arr = new ArrayList<>();

        arr.add(new ListNode(1));
        arr.get(0).next = new ListNode(3);
        arr.get(0).next.next = new ListNode(5);
        arr.get(0).next.next.next = new ListNode(7);

        arr.add(new ListNode(2));
        arr.get(1).next = new ListNode(4);
        arr.get(1).next.next = new ListNode(6);
        arr.get(1).next.next.next = new ListNode(8);

        arr.add(new ListNode(0));
        arr.get(2).next = new ListNode(9);
        arr.get(2).next.next = new ListNode(10);
        arr.get(2).next.next.next = new ListNode(11);

        ListNode head = mergeKLists(arr);

        printList(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    private static ListNode mergeKLists(List<ListNode> arr) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode n : arr) {
            if (n != null) {
                minHeap.offer(n);
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;

            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }
        return res.next;
    }
}
