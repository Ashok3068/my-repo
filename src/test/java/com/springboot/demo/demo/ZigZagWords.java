package com.springboot.demo.demo;

import java.util.ArrayList;

public class ZigZagWords {

    public static void main(String[] args) {
        System.out.println(convert("ABCA", 1));
    }

    static String convert(String s, int numRows) {
        int i = 0;

        char stringChars[] = s.toCharArray();
        ArrayList<StringBuilder> stringList = new ArrayList<>();
        int rowNum = numRows;

        while (rowNum>0) {
            stringList.add(new StringBuilder());
            rowNum--;

        }
        int column = 0;
        while (i < s.length()) {

            if ((column) % numRows== 0) {
                 rowNum = 0;
                while (rowNum < numRows && i < s.length()) {
                    stringList.get(rowNum).append(stringChars[i]);
                    ++i;
                    rowNum++;
                }
                column=column+2;
            } else {
                stringList.get(rowNum-2).append(stringChars[i]);
                i++;
                --rowNum;
                ++column;

            }

        }

        return stringList.stream().reduce((a, b) -> a.append(b)).get().toString();
    }
}
