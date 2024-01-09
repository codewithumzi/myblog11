package com.myblog.myblog11.functional_interface_types;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//PREDICATE FUNCTIONAL INTERFACE:takes input and produces boolean value.
public class PredicateFunctional {
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
        System.out.println();

                //FUNCTION FUNCTIONAL INTERFACE
     // Function functional interface:-Represents a function that takes one argument and produces a result.
    //it has one apply Method

            Function<String,Integer> fun= a->a.length();
            Integer data=fun.apply("umar");
        System.out.println("length of umar is :"+data);
        //we pass string and the result is in Integer
        //now we will pass integer only
        Function<Integer,Integer>fun1=b->b+10;//will add this 10 t0 given no.
        Integer apply = fun1.apply(90);
        System.out.println("after applying value is :" +apply);

        //map() in function functional interface
        List<Integer> numbers = Arrays.asList(20, 38, 42, 11, 21, 9, 34, 9);
        List<Integer> modifiedNos= numbers.stream().map(u->u+10).collect(Collectors.toList());//will add 10 with every no
        System.out.println("after adding 10 new nos are :"+modifiedNos);

        //convert every name to upper or lower case
        List<String> strings = Arrays.asList("Umar", "Amir", "Aqib");
        List<String> upper = strings.stream().map(b -> b.toUpperCase()).collect(Collectors.toList());
        List<String> lower = strings.stream().map(b -> b.toLowerCase()).collect(Collectors.toList());
        System.out.println("converted to upperCase" +upper);
        System.out.println(("converted to lower case :"+lower));


//sort the list using sorted() method
        List<String> strings1 = Arrays.asList("umar", "amir", "hafeez");
        List<String> sortedStrings = strings1.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted strings :"+sortedStrings);

        List<Integer> list = Arrays.asList(43, 2, 11, 31, 54, 99, 21, 1, 121);
        List<Integer> sortedNos = list.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted no.s :"+sortedNos);

        //HOW TO REMOVE DUPLICATE NUMBERS using distinct()
        List<Integer> duplicates = Arrays.asList(82, 43, 21, 11, 4, 33, 21, 11, 82, 99);
        List<Integer> dupRemoved = duplicates.stream().distinct().collect(Collectors.toList());
        System.out.println("duplicate values removed :"+dupRemoved);
    }
}

