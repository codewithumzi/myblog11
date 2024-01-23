package com.myblog.myblog11.xPracticeDebug;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
       List<Integer> data = Arrays.asList(32, 42, 11, 21, 9, 54, 76, 75, 11, 20, 21);
        List<Integer> val = data.stream().filter(x ->x% 2 == 0).collect(Collectors.toList());
        System.out.println(val);
        List<Integer> distinct = data.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);
    }
}
