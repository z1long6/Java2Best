package com.java.concurrent;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Test2Runnable());
//        thread1.setDaemon(true);

        System.out.println("Is Daemon Thread: " + thread1.isDaemon());
        thread1.start();
    }
}

// Test2 class
class Test2Runnable implements Runnable {
    volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }

    public void cancle(){
        flag = false;
    }
}
