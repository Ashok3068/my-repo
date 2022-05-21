package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> combinationSum = new ArrayList<>();
        combinationSum1(new int[]{2, 7, 6, 3, 5, 1}, 9, 0, 0, vali, combinationSum);
        System.out.println(combinationSum.size());

    }

    static ArrayList<Integer> vali = new ArrayList<>();
    static List<List<Integer>> combinationSum = new ArrayList<>();


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;


    }

    public static void combinationSum1(int[] candidates, int target, int sum, int i, ArrayList<Integer> vali, List<List<Integer>> combinationSum) {
        if (i >= candidates.length) {
            return;
        }


        int sum1 = sum + candidates[i];
        if (sum1 < target) {
            ArrayList<Integer> s = new ArrayList<>(vali);


            vali.add(candidates[i]);



            combinationSum1(candidates, target, sum1, i, vali, combinationSum);


            combinationSum1(candidates, target, sum, i + 1, s, combinationSum);


        } else if (sum1 == target) {

            ArrayList<Integer> s = new ArrayList<>(vali);
            vali.add(candidates[i]);
            combinationSum.add(vali);

            combinationSum1(candidates, target, sum, i + 1, s, combinationSum);


        } else {
            combinationSum1(candidates, target, sum, i + 1, vali, combinationSum);
        }


    }


}
