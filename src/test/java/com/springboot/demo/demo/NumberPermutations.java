package com.springboot.demo.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPermutations {

    public static void main(String[] args) {
        List<List<Integer>> s = permute(new int[]{1, 2,3,4});
        System.out.println(s);}
        public static void backtrack(int n,
                              int[] nums,
                              List<List<Integer>> output,
                              int first) {
            // if all integers are used up
            List<Integer> as;

            List<Integer> integerList;
            if (first == n)
                output.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            for (int i = first; i < n; i++) {
                // place i-th integer first
                // in the current permutation
                int temp=nums[first];
                nums[first]=nums[i];
                nums[i]=temp;
                // use next integers to complete the permutations
                backtrack(n, nums, output, first + 1);
                // backtrack
                 temp=nums[first];
                nums[first]=nums[i];
                nums[i]=temp;
            }
        }

        public static List<List<Integer>> permute(int[] nums) {
            // init output list
            List<List<Integer>> output = new LinkedList();

            int n = nums.length;
            backtrack(n, nums, output, 0);
            return output;
        }









}
