package com.sdyin.dsag.arithmetic.alg.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 1114. 按序打印
 * 给你一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 * @Author: liuye
 * @time: 2023/8/25$ 10:15 上午$
 */
public class Foo {

    private static int i = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while(i != 1) {
                condition.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            i = 2;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while(i != 2) {
                condition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            i = 3;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while(i != 3) {
                condition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            i = 1;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
