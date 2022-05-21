package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    public static void main(String[] args) {
       // System.out.println(Arrays.toString(sortNum( new int[]{5,4,2,1,3})));

        System.out.println(findAllMissingNumbers( new int[]{2,3,1,8,2,3,5,1}));


       System.out.println(findMissingNum( new int[]{0,1,4,3,6,5,1}));
    }

/*
* We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created just before the object with sequence number 4.

Write a function to sort the objects in-place on their creation sequence number in O(n)
O(n)
 and without using any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.
*
Input: [3, 1, 5, 4, 2]
*
*
Output: [1, 2, 3, 4, 5]
* */
    private static int[] sortNum(int[] nums) {
        int i=0;
        while(i<nums.length){

            while(nums[i]!=i+1){
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
            i++;

        }
        return nums;
    }

    /*
    *
    *Input: [4, 0, 3, 1]
Output: 2
*
* a[0]=4
* a[4-1]=1
* a[0]=a[3]
* a[0]=1
* a[3]=4 [1,0,3,4]
*  a[0]=1
* a[1-1]=1
* a[0]=a[3]
* a[0]=1
* a[3]=4 [1,0,3,4]
*
    * We are given an array containing n distinct numbers taken from the range 0 to n. Since the array has only n numbers out of the total n+1 numbers, find the missing number.*/


    public static int findMissingNum(int nums[]){
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
            {
               int j= nums[i];
               nums[i]=nums[j];
               nums[j]=j;
            }
            else
                i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    public static Integer secondHighest(List<Integer> list) {
        System.out.println(list.stream().reduce((l1, l2) -> l1 > l2 ? l2 : l1));
        int size = list.size();
        return list.get(size - 2);


    }

    public static List<Integer> findAllMissingNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]-1])
            {
                int j= nums[i];
                nums[i]=nums[j];
                nums[j-1]=j;
            }
            else
                i++;
        }
        return missingNumbers;


     }





}
