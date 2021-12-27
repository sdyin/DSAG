package com.sdyin.dsag.arithmetic.mine.ratelimit;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * 滑动时间窗口限流
 * 假设某个服务最多只能每秒钟处理100个请求，我们可以设置一个1秒钟的滑动时间窗口，
 * 窗口中有10个格子，每个格子100毫秒，每100毫秒移动一次，每次移动都需要记录当前服务请求的次数
 */
public class SlidingTimeWindow {

    //服务访问次数，可以放在Redis中，实现分布式系统的访问计数
    Long counter = 0L;

    //使用LinkedList来记录滑动窗口到每个格子的请求总量
    LinkedList<Long> slots = new LinkedList<Long>();

    public boolean limit() throws InterruptedException {
        if (slots.peekLast() - slots.peekFirst() > 100){
            return false;
        } else {
            counter++;
            return true;
        }

    }

    public void init(){
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(() -> {
            slots.add(counter);
            if (slots.size() > 10){
                slots.removeFirst();
            }
        }, 100, TimeUnit.MILLISECONDS);
    }




}
