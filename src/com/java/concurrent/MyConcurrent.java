package com.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : jt
 * @Description : learn how to use ConcurrentHashMap
 * @Date : Created in 2025/04/20
 */
public class MyConcurrent {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        MyConcurrent myConcurrent = new MyConcurrent();
        myConcurrent.testCyclicBarrier();
    }

    public void testCountDownLatch() throws InterruptedException {
        int n = 10;
        CountDownLatch countDownLatch = new CountDownLatch(n);
        for (int i = 0; i < n; i++) {
            String name = "thread-" + i;
            new Thread(() -> {
                System.out.println("Current Thread: " + Thread.currentThread().getName());
                // countDown()每执行一次,n-1
                countDownLatch.countDown();
            }, name).start();
        }
        // await() method will block current thread
        countDownLatch.await();
        System.out.println("Wait sub Thread from Main Thread: " + Thread.currentThread().getName());
    }

    public void testCyclicBarrier() throws InterruptedException, BrokenBarrierException {
        int n = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
        for (int i = 0; i < n; i++) {
            String name = "thread-" + i;
            new Thread(() -> {
                System.out.println();
                try {
                    System.out.println("Current Thread is waiting: " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }, name).start();
        }
        Thread.sleep(200);
        System.out.println("Main Thread will run until 5 seconds");
        Thread.sleep(5000);
        cyclicBarrier.await();
        System.out.println("Main Thread start run: " + Thread.currentThread().getName());
    }
}
