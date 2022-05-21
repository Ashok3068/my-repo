package com.springboot.demo.demo;

public class FindMinReverseSortArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }

    public static int findMin(int[] nums) {
        int small = nums[0];
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int median = (left + right) / 2;
            if (nums[median] <= small) {
                left = left + 1;
                small = nums[left];
            } else if (left == median) left = median + 1;
            else left = median;

        }
        return small;
    }

}
