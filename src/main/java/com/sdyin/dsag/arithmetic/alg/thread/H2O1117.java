package com.sdyin.dsag.arithmetic.alg.thread;

import java.util.concurrent.Semaphore;

/**
 * @Description: leetcode 1117
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * @Author: liuye
 * @time: 2022/1/14$ 3:01 下午$
 */
public class H2O1117 {

    public H2O1117() {
    }

    private Semaphore s1 = new Semaphore(4);

    private Semaphore s2 = new Semaphore(2);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        s1.acquire(2);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s2.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        s1.release(4);
    }
}
