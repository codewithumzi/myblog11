package com.myblog.myblog11;

public class A {
    public static void main(String[] args) {
      new A().test().example();
    }
    public A test(){
        return new A();
    }
    public void example(){
        System.out.println("hello");
    }
}
