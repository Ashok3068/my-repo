package com.springboot.demo.demo;

public class LargestSubString {
    public static void main(String[] args) {

        System.out.println("length" + lengthOfLongestSubstring("abcabcbb"));

    }

    static  int lengthOfLongestSubstring(String s) {
        String largestSub="";
        for(int j=0;j<s.length();j++){
            String currentsub=""+s.charAt(j);

            for(int i=j+1;i<s.length();i++){

                if(!currentsub.contains(s.substring(i,i+1))){
                    currentsub=currentsub+s.charAt(i);

                }else break;



            }
            if(currentsub.length()>largestSub.length()){
                largestSub=currentsub;

            }

        }



        return largestSub.length();}
}



