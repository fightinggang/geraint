package com.oner.pratice.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author GaoGang
 * @date 2018-03-09
 * CyclicBarrier 用于一组或几组线程，比如一组线程需要在一个时间点上达成一致，例如同时开始一个工作。
 */
public class CyclicBarrierPratice {
    public static class worker implements Runnable {
        private CyclicBarrier barrier;

        public worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始第一步");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 开始第二步");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 开始第三步");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(new worker(barrier));
        executor.submit(new worker(barrier));
        executor.submit(new worker(barrier));
        executor.submit(new worker(barrier));

    }

}
