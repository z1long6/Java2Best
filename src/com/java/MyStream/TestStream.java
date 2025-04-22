package com.java.MyStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(3);
        list2.add(4);
        list2.add(5);

        List<Integer> intersection = list1
                .stream()
                .filter(a -> list2.stream().anyMatch(b -> b == a)).toList();
        System.out.println(intersection);
    }
}
