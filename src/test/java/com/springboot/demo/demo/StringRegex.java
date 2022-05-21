package com.springboot.demo.demo;

public class StringRegex {
    static int i11;

    public static void main(String[] args) {

        System.out.println("true" + isMatch("aaa", "a*a"));
        System.out.println("true" + isMatch("aaa", "ab*a*c*a"));
        System.out.println("false" + isMatch("a", ".*..a*"));
        System.out.println("true" + isMatch("a", "ab*"));
        System.out.println("false" + isMatch("aaa", "aaaa"));
        System.out.println("true" + isMatch("aaa", "aaaa*"));
        System.out.println("true" + isMatch("aaa", "aaab*"));
        System.out.println("false" + isMatch("aaa", "aaa.."));
        System.out.println("true" + isMatch("aaa", "..."));
        System.out.println("false" + isMatch("a", "ab*a"));

        System.out.println("true" + isMatch("aaa", "ab*a*c*a"));
        System.out.println("true" + isMatch("aaab", "b*a*aaab"));
        System.out.println("true" + isMatch("ab", ".*"));
        System.out.println("true" + isMatch("", ".*"));
        System.out.println("true" + isMatch("aasdfasdfasdfasdfas",
                "aasdf.*asdf.*asdf.*asdf.*s"));

        System.out.println("true" + isMatch("aaa", "ab*a*c*a"));

        System.out.println("false" + isMatch("aaa", "aaaa"));



        System.out.println("true" + isMatch("aaab", "b*a*aaab"));

     System.out.println("true" + isMatch("aaa", "a*a"));


    System.out.println("true" + isMatch("aaab", "b*a*aaab"));

        System.out.println("false" + isMatch("a", ".*..a*"));
        System.out.println("false" + isMatch("aa", "a"));
        System.out.println("cou"+i11);

    }



        public static boolean isMatch(String text, String pattern) {

            return dp(0, 0, text, pattern);
        }

        public static boolean dp(int i, int j, String text, String pattern) {
            Boolean ans;
            if(j==pattern.length()){
                ans=i==text.length();
            }else{


            boolean firstMatch = i<text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
            if(j+1<pattern.length()&& pattern.charAt(j+1)=='*')
              ans= dp(i,j+2,text,pattern)|| (firstMatch &&dp(i+1,j,text,pattern));
            else
                ans=firstMatch&&dp(i+1,j+1,text,pattern);}
            return ans;
        }
    }

