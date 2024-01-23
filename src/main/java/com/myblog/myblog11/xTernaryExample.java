package com.myblog.myblog11;

public class xTernaryExample {
    //shorthand way of writing if-else statement also known as conditonal operator
    public static void main(String[] args) {
        int x=29;
        int y=53;
        //using ternary operator to find the maximum value
        int max = (x > y) ? x : y;//if x is > then value goes to x otherwise in y and then goes to max
        System.out.println("the maximum value is :" +max);
    }
}
