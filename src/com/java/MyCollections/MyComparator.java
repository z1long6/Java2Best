package com.java.MyCollections;

import java.util.Comparator;

public class MyComparator implements Comparator<TestSort> {
    @Override
    public int compare(TestSort o1, TestSort o2) {
        return o1.getNum() - o2.getNum();
    }
}
