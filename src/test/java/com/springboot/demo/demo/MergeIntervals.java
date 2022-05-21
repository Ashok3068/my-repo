package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    /*
    *
    *
    * merge intervals
    * (1,5) , (2,8) , (9,10) --> (1,8), (9,10)*/
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    private static Interval[] merge(List<Interval> input) {


        for(Interval input1:input){

        }


        return null;

    }

}
class Interval{
    int start;
    int end;
    public Interval(int x, int y){
        this.start=x;
        this.end=y;
    }
}
