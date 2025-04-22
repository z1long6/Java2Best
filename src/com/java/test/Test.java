package com.java.test;

public class Test {
    public static void main(String[] args) {
        Father father = (Father) new Son();
        System.out.println(father.getName("111"));
    }
}
