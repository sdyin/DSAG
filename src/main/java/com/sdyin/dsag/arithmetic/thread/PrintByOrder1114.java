package com.sdyin.dsag.arithmetic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个不同的线程 A、B、C 将会共用一个Foo实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * ReentrantLock 方式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintByOrder1114 {

    public PrintByOrder1114() {

    }

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private int status = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (status != 1) {
                condition.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            status = 2;
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while (status != 2) {
                condition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            status = 3;
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while (status != 3) {
                condition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            status = 1;
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }
}
