package com.java.MyCollections;

import com.java.test.Test;

import java.util.*;


public class Main {
    public static void main(String[] args) {
//        Map<String, String>map = new TreeMap<>();
//        map.put("a", "1");
//        Set<String>set1 = map.keySet();
//        Collection<String> set2 = map.values();
//
//        set1.forEach(System.out::println);
//        set2.forEach(System.out::println);
//        Main.Test1();
        TestSort sort1 = new TestSort(2,"asdf");
        TestSort sort2 = new TestSort(1,"asdf");
        List<TestSort>list = new LinkedList<>();
        list.add(sort1);
        list.add(sort2);
        list.forEach(System.out::println);
        Collections.sort(list, new MyComparator());
        list.forEach(System.out::println);
//        list.add("1");
//        list.add("2");
//        System.out.println(list.get(1));
    }

    public static void Test1(){
        String str = "This is a apple, here is a apple!";
        String [] str_array = str.split("\\W+");
        Map <String, Integer> map = new HashMap<>();
        for (String s : str_array){
            if (!map.containsKey(s)){
                map.put(s, 1);
            }else {
                map.put(s, map.get(s)+1);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("[key]: " + entry.getKey() + "[counts]: " + entry.getValue());
        }
    }
}
