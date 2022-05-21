package com.springboot.demo.demo;


public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int target) {
        if (target > 1) {
            int[] numb = new int[target + 1];
            numb[1] = 1;
            numb[2] = 2;
            for (int i = 3; i < numb.length; i++) {
                numb[i] = numb[i - 2] + numb[i - 1];
            }
            return numb[target];
        } else return target;

    }


}

