package com.sdyin.dsag.arithmetic.alg.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Description: leetcode 1116. 打印零与奇偶数
 * @Author: liuye
 * @time: 2022/1/10$ 11:09 下午$
 */
public class ZeroEvenOdd1116 {

    private int n;

    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);

    public ZeroEvenOdd1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s1.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                s2.release();
            } else {
                s3.release();
            }
        }
    }

    /**
     * 只输出偶数
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    /**
     * 只输出奇数
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
}
