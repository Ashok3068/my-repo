package com.springboot.demo.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MaxWater {

    public static int maxArea(int[] height) {
        if (height.length < 1) return 0;
        Map<Integer, Integer> mapXYAxis = new LinkedHashMap<>();
        int maxSize = 0;

        for (int i = 0; i < height.length; i++) {
            int xAxis = i + 1;
            int yAxis = height[i];

            for (int j = i + 1; j < height.length; j++) {
                int xAxis1 = j + 1;
                int yAxis1 = height[j];
                int size = Math.abs(xAxis - xAxis1) * (yAxis > yAxis1 ? yAxis1 : yAxis);
                if (size > maxSize) {
                    maxSize = size;
                }
            }


        }

        return maxSize;

    }

    public static int maxArea1(int[] height) {
        if (height.length < 1) return 0;
        int maxSize = 0;
        int left = 0;
        int right = height.length - 1;


        while (left < right) {

            int size = Math.abs(right - left) * (height[left] > height[right] ? height[right] : height[left]);
            maxSize = Math.max(size, maxSize);
            if (height[left] < height[right]) {
                left++;
            } else

                --right;
        }


        return maxSize;

    }


    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum = windowSum + arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum = windowSum - arr[windowStart];
                ++windowStart;
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
     /*   System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));*/
        System.out.println(maxArea1(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}
