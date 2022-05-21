package com.springboot.demo.demo;

import java.util.*;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        // geberateParanathesis(new StringBuilder(),0,0,1);
        // System.out.println(stringArrayList);
        // System.out.println(binarySearch( new int[]{1,2,3,4,8,9,10},4));
        // sortElements();
       // getJosephsProblem(14,1);
        System.out.println(lengthOfLongestSubstring("pwwkew"));

       // nearestMap(5,new int[]{1,2,3,4,8,9,10});

    }

    static ArrayList<String> stringArrayList = new ArrayList();

    static void generateParanathesis(StringBuilder s, int left, int right, int length) {
        if (left + right == 2 * length) {
            stringArrayList.add(s.toString());
            return;
        }
        if (left < length) {
            s.append("(");
            generateParanathesis(s, left + 1, right, length);
            s.deleteCharAt(s.length() - 1);
        }
        if (right < left) {
            s.append(")");
            generateParanathesis(s, left, right + 1, length);
            s.deleteCharAt(s.length() - 1);
        }
    }
    /*123456 key 4
     *median =3
     * left =3, right=5
     *
     * r
     *
     * */

    static Boolean binarySearch(int a[], int key) {
        int left = 0, right = a.length - 1;


        while (left < right) {
            int median = (left + right) / 2;


            if (key > a[median])
                left = median + 1;
            else if (key < a[median])
                right = median;
            else if (a[median] == key)
                return true;
            else return false;
        }
        return false;
    }

    static int getJosephsProblem(int n, int position) {
        int k = position-1;
        int soldiers[] = new int[n];
        if (soldiers.length == 1)
            System.out.println("solution found" + (k + 1));
        else {
            int y = position;
            soldiers[y] = -1;

            while (k != y) {
                k = y + 1;
                if (k >= soldiers.length) k = 0;
                k = kill(k, soldiers);
                y = kill(k + 1 >= soldiers.length ? 0 : k + 1, soldiers);
                if (k != y)
                    soldiers[y] = -1;
            }
            System.out.println("solution found" + (k + 1));
        }
        return k + 1;

    }

    static int kill(int n, int soldiers[]) {
        int left = n;
        int right = soldiers.length - 1;
        while (soldiers[left] == -1 && left <= right) {
            left = left + 1;
            if (left >= soldiers.length) {
                left = 0;
                right = n;
            }
        }
        if (left > right) return n;

        return left;

    }

    public static  void nearestMap(int key, int numbers[]){
       Map<Integer,Integer> diffMap=new java.util.HashMap<>();
       for(int i=0;i<numbers.length;i++){
           diffMap.put(numbers[i],Math.abs(key-numbers[i]));
       }

        Map.Entry<Integer, Integer> min = null;
        for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }

        System.out.println(min.getKey());




    }


        public static int lengthOfLongestSubstring(String s) {
            int windowStart=0;
            int windowEnd=0;
            int length=0;
            java.util.HashMap<Character,Integer> characterFrequencyMap= new java.util.HashMap<Character, Integer>();


            for (;windowEnd<s.length();windowEnd++){
                if(characterFrequencyMap.containsKey(s.charAt(windowEnd))){
                    while(characterFrequencyMap.containsKey(s.charAt(windowEnd))){
                        characterFrequencyMap.remove(s.charAt(windowStart));
                        ++windowStart;


                    }

                }
                    characterFrequencyMap.put(s.charAt(windowEnd),1);

                length=Math.max(length, windowEnd-windowStart+1);

            }
            return length;
        }


    }















