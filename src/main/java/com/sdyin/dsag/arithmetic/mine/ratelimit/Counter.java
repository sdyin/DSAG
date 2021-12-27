package com.sdyin.dsag.arithmetic.mine.ratelimit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流算法-计数器法
 */
public class Counter {

    // 当前时间
    public long timeStamp = System.currentTimeMillis();

    // 初始化计数器
    public AtomicInteger reqCount = new AtomicInteger(0);

    // 时间窗口内最大请求数
    public final int limit = 100;

    // 时间窗口ms
    public final long interval = 1000 * 60;

    /**
     * 限流
     * @return
     */
    public boolean limit(){
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval) {
            reqCount.addAndGet(1);
            return reqCount.get() <= limit;
        } else {
            reqCount = new AtomicInteger(1);
        }
        return true;
    }
}
