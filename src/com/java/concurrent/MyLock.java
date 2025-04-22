package com.java.concurrent;

import java.util.concurrent.locks.*;

public class MyLock {
    public int shared;
    public void unsafeExample(){
        while (shared < 10000){
            int from = shared++;
            int latter = shared;
            if (from != latter - 1){
                System.out.println("[latter]: " + latter + " [shared]: " + shared);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyLock lock = new MyLock();
        Thread threadA = new Thread(lock::unsafeExample);
        Thread threadB = new Thread(lock::unsafeExample);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }

}
