package com.springboot.demo.demo;

public class LargestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));

    }

    static String longestPalindrome(String s) {
        char[] c = s.toCharArray();

        int currentLoop = 0;


        String largestPalindrome = String.valueOf(c[0]);
        for (int i = 1; i < s.length(); i++) {
            currentLoop = i;
            int startPoint = -1;
            while (currentLoop != 0) {
                if (c[currentLoop - 1] == c[i]) {
                    startPoint = --currentLoop;
                    if (startPoint != -1 && i - startPoint >= largestPalindrome.length() && checkPalindrome(c, startPoint, i)) {

                        largestPalindrome = s.substring(startPoint, i + 1);

                    }
                    continue;

                }
                currentLoop--;

            }


        }
        if (largestPalindrome.length() == 0) {
            largestPalindrome = String.valueOf(c[0]);

        }

        return largestPalindrome;
    }

    static boolean checkPalindrome(char c[], int begining, int end) {

        boolean palin = true;

        while (begining <= end && palin) {
            palin = false;

            if (end - begining == 1) {
                palin = true;
                break;
            } else if (c[++begining] == c[--end]) {
                palin = true;
            }


        }
        return palin;
    }
}


