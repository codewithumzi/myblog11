package com.myblog.myblog11;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//PREDICATE FUNCTIONAL INTERFACE:takes input and produces boolean value.
public class PredicateFunctionalinterface {
    //to check even
    public static void main(String[] args) {
        Predicate<Integer> val = x -> x % 2 == 0;
        boolean result = val.test(23);
        System.out.println(result);

//String
        Predicate<String> odd = str-> str.equals("umar");
        boolean value = odd.test("umaid");
        System.out.println(value);

//fetching odd and even no.s from list of array
        List<Integer> values = Arrays.asList(78, 32, 3, 5, 21, 11, 88, 10, 2, 100);
        List<Integer> evenNumbers = values.stream().filter(z -> z % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNumbers = values.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());
        System.out.println("list of even numbers :" + evenNumbers);
        System.out.println("list of odd numbers :" + oddNumbers);
//string example startsWith(),endsWith(),equals(),size()
        List<String> str = Arrays.asList("umar", "shakir", "amir", "kashif", "umar", "asif","umaid");
        List<String> starts = str.stream().filter(s -> s.startsWith("u")).collect(Collectors.toList());
        List<String> ends = str.stream().filter(s -> s.endsWith("f")).collect(Collectors.toList());
        List<String> equals = str.stream().filter(s -> s.equals("umar")).collect(Collectors.toList());//how many times
        System.out.println("names start with u :"+starts);
        System.out.println("names end with f :" +ends);
        System.out.println(equals);
        System.out.println(equals.size());//if we use only equals () then name will be in output

    }
}
