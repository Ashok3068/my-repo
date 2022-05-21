package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,2,5}));
    }

    public static int missingNumber(int[] nums) {

        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {

            list.add(nums[i]);
        }

        int num = 0;

        while (num < nums.length) {
            if (!list.contains(num)) {
                return num;
            }
            num = num + 1;

        }


        return nums.length;

    }
}
