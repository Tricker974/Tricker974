package com.test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ContainTest {
    public static void main(String[] args) {
        String list1="01,02,04,05,07,";
        String list2="08,09,05,10,01";
       List<String> strings = Arrays.asList(list1.split(","));
        List<String> strings2 = Arrays.asList(list2.split(","));
        /* strings.remove(strings.size()-1);*/
//        System.out.println(list1.substring(0,list1.lastIndexOf(",")));
        // 交集
        List<String> intersection = strings.stream().filter(item -> strings2.contains(item)).collect(toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out::println);
        System.out.println("---交集个数---");
        System.out.println(intersection.size());


    }
}
