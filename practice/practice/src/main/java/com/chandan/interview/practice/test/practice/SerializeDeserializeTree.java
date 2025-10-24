package com.chandan.interview.practice.test.practice;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


public class SerializeDeserializeTree {

    private TreeNode root;

    public String serialize(TreeNode root){
        this.root = root;

        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                result.append("N,");
            }
            else {
                result.append(curr.val).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return result.toString();
    }

    public TreeNode deSerialize(String input){

        if(input == null)
            return null;

        String[] arr = input.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = new TreeNode(Integer.parseInt(arr[0]));

        queue.add(treeNode);
        int index = 1;

        while (!queue.isEmpty()){

            TreeNode curr = queue.poll();

            if(!Objects.equals(arr[index], "N")){
                curr.left = new TreeNode(Integer.parseInt(arr[index]));
                queue.add(curr.left);
            }
            index++;

            if(!Objects.equals(arr[index], "N")){
                curr.right = new TreeNode(Integer.parseInt(arr[index]));
                queue.add(curr.right);
            }
            index++;

        }

        return treeNode;

    }

    public void printInorder(TreeNode root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.val +"   ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        SerializeDeserializeTree serializeDeserializeTree = new SerializeDeserializeTree();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        serializeDeserializeTree.printInorder(treeNode);

        String res = serializeDeserializeTree.serialize(treeNode);
        System.out.println();
        System.out.println(res);
        System.out.println();
        TreeNode res1 = serializeDeserializeTree.deSerialize(res);
        System.out.println(res1);
        serializeDeserializeTree.printInorder(res1);




    }
}
