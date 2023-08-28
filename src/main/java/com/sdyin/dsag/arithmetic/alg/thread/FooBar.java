package com.sdyin.dsag.arithmetic.alg.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: leetcode-thread: 1115. 交替打印FooBar
 * 两个不同的线程将会共用一个 FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * TODO: 更多种不同解法待续
 * @Author: liuye
 * @time: 2021/4/2$ 下午5:10$
 */
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }
}

/**
 * 通过synchronized锁方式
 */
class FooBar_Synchronized{
    private int n;

    private Object obj = new Object();
    private int status = 0;

    public FooBar_Synchronized(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                while (status != 0) {
                    obj.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                status = 1;
                obj.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj){
                while (status != 1){
                    obj.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                status = 0;
                obj.notifyAll();
            }
        }
    }
}

/**
 * 通过ReentrantLock 加锁方式
 */
class FooBar_ReentrantLock {

    private int n;

    private int status = 0;

    public FooBar_ReentrantLock(int n) {
        this.n = n;
    }

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (status != 0) {
                    condition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                status = 1;
            } finally {
                condition.signalAll();
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (status != 1){
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                status = 0;
            } finally {
                condition.signalAll();
                lock.unlock();
            }
        }
    }

}

/**
 * 使用阻塞队列BlockingQueue方式
 */
class FooBar_BlockingQueue {

    private int n;
    private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);

    public FooBar_BlockingQueue(int n){
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.put(i);
            printFoo.run();
            bar.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.take();
            printBar.run();
            foo.take();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar_BlockingQueue fb = new FooBar_BlockingQueue(3);
        Thread t1 = new Thread(() -> {
            try {
                fb.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fb.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(10);
    }

}

/**
 * cyclicBarrier 方式
 */
class FooBar_CyclicBarrier{

    private int n;

    public FooBar_CyclicBarrier(int n){
        this.n = n;
    }

    CyclicBarrier cb = new CyclicBarrier(2);

    volatile boolean flag = false;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //加入while是保证第二次打印foo之前已经第一次打印了bar
            //即控制不同循环次数仍然有序
            while (flag){};
            printFoo.run();
            flag = true;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                //保证第一次循环后执行打印bar
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            flag = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar_CyclicBarrier fb = new FooBar_CyclicBarrier(3);

        Thread.sleep(10);
    }
}


