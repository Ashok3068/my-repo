package com.springboot.demo.demo;

public class RainWater {

    public int trap(int[] height) {
        int small=0;

        for(int i=0;i<height.length;i++){
            if(height[i]<small){

            }
            else small=height[i];
        }

        return 0;

    }
}
