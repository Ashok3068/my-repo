package com.springboot.demo.demo;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));

    }

    static int myAtoi(String s) {
        char c[] = s.trim().toCharArray();
        int constrant = (int) Math.pow(2, 31);
        int constrant1 = (int) Math.pow(-2, 31);

        if (c.length == 0) return 0;
        double number = 0;
        int i = 0;
        int multiplier = 1;
        if (c[0] == '-') {
            multiplier = -1;
            i++;

        } else if (c[0] == '+')
            i++;
        while (i < c.length) {
            if (Character.isDigit(c[i]))
                number = number * 10 + Character.getNumericValue(c[i]);
            else {
                return multiplier * (int) number;
            }

            if (number > (constrant)) {
                if (multiplier == -1) {
                    if (number >= constrant + 1) {
                        return constrant1;
                    }
                } else
                    return constrant;
            }
            i++;

        }
        return multiplier * (int) number;
    }
}
