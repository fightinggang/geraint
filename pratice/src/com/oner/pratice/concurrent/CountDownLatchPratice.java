package com.oner.pratice.concurrent;

import java.util.concurrent.*;

/**
 * @author GaoGang
 * @date 2018-03-09
 * CountDownLatch 适用于一组线程和另一个主线程之间的工作协作。
 * 一个主线程等待一组工作线程的任务完毕才继续它的执行是使用 CountDownLatch 的主要场景
 */
public class CountDownLatchPratice {
    public static void main(String[] args) {
        int count = 6;
        CountDownLatch signal = new CountDownLatch(count);
        ExecutorService executor = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++) {
            executor.execute(new WorkerRunnable(signal));
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(Thread.currentThread().getName() + "  start");
//                        TimeUnit.MILLISECONDS.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        System.out.println(Thread.currentThread().getName() + "  end");
//                        signal.countDown();
//                    }
//                }
//            });
        }
        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work finished");
    }
}

class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;

    WorkerRunnable(CountDownLatch doneSignal) {
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "  start");
            // do work
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "  end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }
}
