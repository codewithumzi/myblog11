package com.myblog.myblog11.xPracticeDebug;

public class SampleTest {
    public static int test1() {
        System.out.println(200);
        SampleTest sampleTest=new SampleTest();
        int otp = sampleTest.returnOtp();
        return otp;

    }
    public int returnOtp(){
    return 12345;
    }
}
