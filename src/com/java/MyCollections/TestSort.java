package com.java.MyCollections;

public class TestSort implements Comparable<TestSort>{
    private int num;
    private String name;

    public TestSort(int num, String name) {
        this.num = num;
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(TestSort o) {
        return this.num - o.num;
    }

    @Override
    public String toString() {
        return "TestSort [num=" + num + ", name=" + name + "]";
    }
}
