package com.chandan.interview.practice.test.practice.practice;

import java.util.*;

class Tree {
    int val;
    Tree left;
    Tree right;

    Tree(int x) {
        val = x;
    }
}


public class SerializeAndDeserializeBinaryTree {

    public String serialize(Tree root) {

        StringBuilder sb = new StringBuilder();
        preOrderSerialization(root, sb);

        return sb.toString();

    }

    private void preOrderSerialization(Tree root, StringBuilder sb) {
        if (root == null)
            sb.append("#,");
        else {
            sb.append(root.val).append(",");
            preOrderSerialization(root.left, sb);
            preOrderSerialization(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Tree deserialize(String data) {
        String[] nodes = data.split(",");

        Queue<String> pq = new LinkedList<>(Arrays.asList(nodes));

        return buildTree(pq);

    }

    private Tree buildTree(Queue<String> pq) {


        String data = pq.poll();

        if (data != null && data.equals("#")) {
            return null;
        }
        Tree tree = new Tree(Integer.parseInt(data));
        tree.left = buildTree(pq);
        tree.right = buildTree(pq);

        return tree;

    }

    public void print(Tree tree) {

        if (tree == null) {
            return;
        }

        System.out.print(tree.val + "- ");
        print(tree.left);
        print(tree.right);

    }

    public static void main(String[] args) {

        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();

        Tree root = new Tree(10);
        root.left = new Tree(20);
        root.right = new Tree(30);
        root.left.left = new Tree(40);
        root.left.right = new Tree(60);

        String arr = serializeAndDeserializeBinaryTree.serialize(root);

        System.out.println(arr);

        root = serializeAndDeserializeBinaryTree.deserialize(arr);

        serializeAndDeserializeBinaryTree.print(root);

    }
}
