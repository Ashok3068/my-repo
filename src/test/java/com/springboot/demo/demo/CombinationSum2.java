package com.springboot.demo.demo;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {


        combinationSum2(new int[]{2,5,1,1,2,3,3,3,1,2,2}, 5);

        System.out.println(combinationSum.size());

    }
    static   List<List<Integer>> combinationSum;




    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {


        ArrayList<Integer> vali;  vali = new ArrayList<>();
       combinationSum = new ArrayList<>();
        combinationSum1(candidates, target, 0, 0, vali, combinationSum);

        return combinationSum;


    }

    public static void combinationSum1(int[] candidates, int target, int sum, int i, ArrayList<Integer> vali, List<List<Integer>> combinationSum) {
        if (i >= candidates.length) {
            return;
        }


        int sum1 = sum + candidates[i];
        if (sum1 < target) {
            ArrayList<Integer> s = new ArrayList<>(vali);
            combinationSum1(candidates, target, sum, i + 1, s, combinationSum);
            vali.add(candidates[i]);
            combinationSum1(candidates, target, sum1, i + 1, vali, combinationSum);


        } else if (sum1 == target) {

            ArrayList<Integer> s = new ArrayList<>(vali);
            vali.add(candidates[i]);
            Collections.sort(vali);
            Boolean repeated = false;
            for (List s1 : combinationSum) {
                if (s1.equals(vali)) {
                    repeated = true;
                    break;
                }

            }
            if (!repeated)
                combinationSum.add(vali);

            combinationSum1(candidates, target, sum, i + 1, s, combinationSum);


        } else {
            combinationSum1(candidates, target, sum, i + 1, vali, combinationSum);
        }


    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
