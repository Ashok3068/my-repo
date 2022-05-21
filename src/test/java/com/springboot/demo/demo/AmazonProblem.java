package com.springboot.demo.demo;

import java.util.Arrays;
import java.util.List;

public class AmazonProblem {
    public static void main(String[] args) {
        System.out.println(findSegments(3,Arrays.asList(1,2,3,4)));
    }
    public static int findSegments(int balanceWeight, List<Integer> weights){
        int left=0;
        int right=0;
        int count=0;
        if(weights.size()>0) count=1;



        int minWeight=weights.get(right);
        int maxWeight=weights.get(right);
        ++right;
        while(right<weights.size()){
                ++count;

            minWeight=Math.min(minWeight,weights.get(right));
            maxWeight=Math.max(maxWeight,weights.get(right));
            if(maxWeight-minWeight<=balanceWeight)
                ++count;
            else{
                while(left+1<right){
                    if(weights.get(left)==minWeight){

                        minWeight=findMin(left+1,right,weights);
                    }
                    if(weights.get(left)==maxWeight){
                        maxWeight=findMax(left+1,right,weights);

                    }

                    if(maxWeight-minWeight<=balanceWeight)
                        ++count;
                        ++left;
                }

            }++right;


        }
        while(left+1<weights.size()){
            if(weights.get(left)==minWeight){

                minWeight=findMin(left+1,weights.size()-1,weights);
            }
            if(weights.get(left)==maxWeight){
                maxWeight=findMax(left+1,weights.size()-1,weights);

            }

            if(maxWeight-minWeight<=balanceWeight)
                ++count;
            ++left;
        }
        return count;
    }

    public static int findMin(int left, int right, List<Integer> weights){
        int minWeight=weights.get(left);
        while(left<right){
            minWeight=Math.min(minWeight,weights.get(right));
            ++left;
        }
        return minWeight;
    }
    public static int findMax(int left, int right, List<Integer> weights){
        int maxWeight=weights.get(left);
        while(left<right){
            maxWeight=Math.max(maxWeight,weights.get(right));
            ++left;
        }
        return maxWeight;
    }
}
