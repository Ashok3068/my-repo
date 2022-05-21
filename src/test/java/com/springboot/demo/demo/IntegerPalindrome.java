package com.springboot.demo.demo;

public class IntegerPalindrome {
    public static void main(String[] args) {
        isPalindrome(121);

    }

    static boolean isPalindrome(int x) {
        int original=x;
        if (x < 0) return false;
        int palind = 0;
        if (x > 0) {
            while (x != 0) {
                palind = palind * 10 + (x % 10);
                x = x / 10;
            }

            if (original == palind) return true;
            else return false;
        }


        return true;
    }
}
