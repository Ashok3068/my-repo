package com.springboot.demo.demo;

public class FractionSubtraction {
    public static void main(String[] args) {
        System.out.println(fractionAddition("-5/2+10/3+7/9"));

    }

    public static String fractionAddition(String expression) {
        int[] negative=null ;
        int[] positive=null ;
        while (expression.length()>2) {
            if (expression.charAt(0) == '-') {
                    if (negative != null) {
                        String[] sb = expression.split("/");
                        int numer = Integer.valueOf(sb[0].substring(1));
                        int denom = Integer.valueOf(sb[1].split("\\+|-")[0]);
                        negative[0] = negative[0]* denom+ numer* negative[1];
                        negative[1]=negative[1]*denom;
                        expression=expression.substring(expression.indexOf("-"));
                    } else {
                        negative= new int[2];
                        String[] sb = expression.split("/");
                        negative[0] = Integer.valueOf(sb[0].substring(1));
                        negative[1] = Integer.valueOf(sb[1].split("\\+|-")[0]);
                        expression=expression.substring(expression.indexOf(String.valueOf(negative)));

                    }
            } else if (expression.charAt(0) == '+') {
                    if (positive != null) {
                        String[] sb = expression.split("/");
                        int numer = Integer.valueOf(sb[0].substring(1));
                        int denom = Integer.valueOf(sb[1].split("\\+|-")[0]);
                        positive[0] = positive[0]* denom+ numer* positive[1];
                        positive[1]=positive[1]*denom;
                        expression=expression.substring(expression.indexOf("+"));
                    } else {
                        positive= new int[2];
                        String[] sb = expression.split("/");
                        positive[0] = Integer.valueOf(sb[0].substring(1));
                        positive[1] = Integer.valueOf(sb[1].split("\\+|-")[0]);
                        expression=expression.substring(expression.indexOf("+"));
                    }
            } else {
                    positive= new int[2];
                    String[] sb = expression.split("/");
                    positive[0] = Integer.valueOf(sb[0].substring(1));
                    positive[1] = Integer.valueOf(sb[1].split("\\+|-")[0]);
                expression=expression.substring(expression.indexOf(String.valueOf(positive)));



            }
            if(expression.indexOf("+")!=-1 ||expression.indexOf("-")!=-1)
            expression=expression.substring(expression.indexOf("\\+|-"));

        }

        int numerator = 0;
        int denominator = 0;

        if (positive == null) {


            numerator = positive[0];

            denominator = positive[1];


        } else if (negative == null) {

            numerator =negative[0];

            denominator = negative[1];
        } else {


            int numeratorNegative =  negative[0];

            int denominatorNegative = negative[1];

            int numeratorPositive =  positive[0];

            int denominatorPositive =  positive[1];

            numerator = numeratorPositive * denominatorNegative - denominatorPositive * numeratorNegative;

            denominator = denominatorPositive * denominatorNegative;


        }


        int i = 2;
        while (i <= 9 && i <= denominator && i <= numerator)
            if (numerator % i == 0 && denominator % i == 0) {
                numerator = numerator / i;
                denominator = denominator / i;
            } else i++;

        if (numerator == 0) {
            denominator = 1;
        }


        return numerator + "/" + denominator;

    }


}
