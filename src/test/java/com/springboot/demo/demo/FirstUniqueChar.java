package com.springboot.demo.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> countChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
           countChar.put(s.charAt(i),countChar.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
           if(countChar.get(s.charAt(i))==1)
               return i;
        }
        return  -1;

    }
}