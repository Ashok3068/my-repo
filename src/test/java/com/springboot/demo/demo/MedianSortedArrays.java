package com.springboot.demo.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 =
                {1,1,1,1,1,1,1,1,1,1,4,4};






        int[] nums2 = {1,3,4,4,4,4,4,4,4,4,4};
        LinkedListNode node = new LinkedListNode();


        for (int i = 0; i < nums1.length; i++) {
            node.add(nums1[i]);
        }
        System.out.println(node);
        node.deleteLast();
        node.deleteLast();
        //node.deleteFirst();

        System.out.println(node);


         System.out.println(findMedianSortedArrays1(nums1, nums2));

    }



    static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;


        float[] finalArray = new float[length];
        int i = 0;
        int j = 0;
        int k = 0;
        int q = 0;
        while (i < length) {
            if (k >= nums1.length && q >= nums2.length) {
                break;

            }
            if (k >= nums1.length) {
                i++;
                finalArray[j] = nums2[q];
                q++;
                j++;
                continue;
            } else if ((q >= nums2.length)) {
                i++;
                finalArray[j] = nums1[k];
                k++;
                j++;

                continue;
            }
            int smallest = nums1[k];
            if (smallest > nums2[q]) {
                smallest = nums2[q];
                q++;
                finalArray[j] = smallest;

            } else if (smallest == nums2[q]) {
                finalArray[j] = smallest;
                //finalArray[++j] = smallest;
                q++;
                k++;
            } else {

                finalArray[j] = smallest;
                k++;
            }
            i++;
            j++;

        }
        double median = j % 2 == 0 ? (finalArray[j / 2 - 1] + finalArray[(j / 2)]) / 2.0 : finalArray[j / 2];
        return median;


    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        int[] finalArray = new int[length];

        LinkedListNode list1 = new LinkedListNode();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        LinkedListNode list2 = new LinkedListNode();
        for (int i = 0; i < nums2.length; i++) {
            list1.add(nums2[i]);
        }



        int i = 0;
        while (list1.getFirst() ==0 && list2.getFirst() == 0) {
            if (list1.getFirst() < list2.getFirst()) {
                finalArray[i] = list1.getFirst();
                list1.deleteFirst();
            } else {
                finalArray[i] = list1.getFirst();
                list2.deleteLast();
            }
        }


        double median = length % 2 == 0 ? (finalArray[length / 2 - 1] + finalArray[(length / 2)]) / 2.0 : finalArray[length / 2];
        return median;


    }

    static class Node {
        public Node next;
        public int value;


        Node(int value) {

            next = null;
            this.value = value;
        }

    }
    static  class LinkedListNode{
        public  Node head;
        public  void add(int value){
            Node node1=new Node(value);
            if(this.head==null)
                this.head=node1;
            else{
               Node curr= this.head;


               while(curr.next!=null){
                   curr=curr.next;
               }
               curr.next=node1;

            }

        }
        public void deleteFirst(){
            this.head=head.next;
        }

        public void deleteLast() {
            Node curr = this.head;
            Node prev=curr;
            if(curr.next==null)
                this.head=null;

            while (curr.next != null) {
                prev=curr;

                curr = curr.next;

            }
            prev.next=null;



        }
        public int getFirst(){
           return this.head.value;
        }
    }





}
