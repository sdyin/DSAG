package com.sdyin.dsag.arithmetic.alg.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: leetcode: 1226. 哲学家进餐
 * 核心点: 防止死锁
 * @Author: liuye
 * @time: 2022/1/16$ 3:46 下午$
 */
public class DiningPhilosophers {

    public DiningPhilosophers() {

    }

    private ReentrantLock lock = new ReentrantLock();

    /**
     * 串行解法
     * @param philosopher
     * @param pickLeftFork
     * @param pickRightFork
     * @param eat
     * @param putLeftFork
     * @param putRightFork
     * @throws InterruptedException
     */
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            lock.unlock();
        }
    }
}
