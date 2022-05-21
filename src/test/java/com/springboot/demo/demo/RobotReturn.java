package com.springboot.demo.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RobotReturn {

    public static void main(String[] args) {
        System.out.println(judgeCircle("LL"));
    }

    public static boolean judgeCircle(String moves) {

        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U')
                ++x;
            if (moves.charAt(i) == 'D')
                --x;
            if (moves.charAt(i) == 'L')
                ++y;
            if (moves.charAt(i) == 'R')
                ++y;

        }


        if (x == 0 && y == 0) return true;


        return false;
    }
}

