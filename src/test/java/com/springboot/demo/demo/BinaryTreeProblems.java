package com.springboot.demo.demo;

import java.util.Scanner;

class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;
    BinaryTree(int data){
        this.data=data;
    }

}


public class BinaryTreeProblems {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        BinaryTree root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(findBinaryTreeDepth(root));
    }
static int left=0;
    static int right=0;
    static int count=0;
    private static int findBinaryTreeDepth(BinaryTree root) {
        if(root==null) return -1;

        int   left=findBinaryTreeDepth(root.left);
        int right=  findBinaryTreeDepth(root.right);
         count=Math.max(left,right)+1;

return count;

    }
    public static BinaryTree insert(BinaryTree root, int data) {
        if(root == null) {
            return new BinaryTree(data);
        } else {
            BinaryTree cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }



}


