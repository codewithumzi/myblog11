package com.myblog.myblog11.xPracticeDebug;

public class TestClass {
    public static void main(String[] args) {
        TestClass testClass=new TestClass();
        System.out.println(100);
        System.out.println(200);
        int val = testClass.test();
        System.out.println(val);
    }
    public int test(){
       int otp= SampleTest.test1();
       return otp;
    }
}
