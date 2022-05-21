package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {



    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
        System.out.println("count"+k);


    }
    static int k=0;
    public static   List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n>0){

          generateValidParanthesis(list,new StringBuilder(),0,0,n);

        }
        return list;

    }


    public static void generateValidParanthesis(List<String> list, StringBuilder paranthesis, int left,int right,int size) {
        k++;


        if (paranthesis.length() == 2*size ) {
            list.add(paranthesis.toString());
            return ;
        }

        if(left<size){
            paranthesis.append("(");
            generateValidParanthesis(list,paranthesis,left+1,right,size);
            paranthesis.deleteCharAt(paranthesis.length()-1);
            // call1 left 1 right 0 (
            // call2 left 2 right 0  ((
            //call3 left 3 right 0 (((

            //delete 3 ((

            // call2

            //delete 2 ( left 0


        }
        if(right<left){
            paranthesis.append(")");
            generateValidParanthesis(list,paranthesis,left,right+1,size);
            paranthesis.deleteCharAt(paranthesis.length()-1);
                                                    //2call left2 right0
            //left 3  right 1 ((()    //left 2  right 0 (()  generateValidParanthesis(2,1)_>response (()(
                                                                             // generateValidParanthesis(3,1)-> (()(
            //


            //left 3  right 2 ((())   //left 3  right 2 ((())               //(()() generateValidParanthesis(3,2)-> (()())
            //left 3  right 3 ((()))   //left 3  right 3 ((()))                 delete (()((
                                                                        //       delete (()(
            //delete ((())
            //delete ((()
            //delete (((

        }


}}
