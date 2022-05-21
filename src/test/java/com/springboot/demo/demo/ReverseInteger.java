package com.springboot.demo.demo;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));

    }

    static int reverse(int x) {

        int constrant=(int) Math.pow(2,31);
        double reverseNum=0;
        if(x<(constrant*-1) || x>(constrant) ){
            return 0;
        }
        while (x!=0){
            reverseNum= reverseNum*10+x%10;
            if(reverseNum<(constrant*-1) || reverseNum>(constrant) ){
                return 0;
            }
            x=x/10;
        }

        if(reverseNum<(constrant*-1) || reverseNum>(constrant) ){
            return 0;
        }
        return (int)reverseNum;

    }
}
