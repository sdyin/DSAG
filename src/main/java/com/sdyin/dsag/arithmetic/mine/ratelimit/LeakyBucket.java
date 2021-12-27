package com.sdyin.dsag.arithmetic.mine.ratelimit;

/**
 * 限流算法-漏桶算法
 */
public class LeakyBucket {

    // 当前时间
    public long timeStamp = System.currentTimeMillis();
    // 桶的容量
    public long capacity;
    // 水漏出的速度(每秒系统能处理的请求数)
    public long rate;
    // 当前水量(当前累积请求数)
    public long water;

    public boolean limit(){
        long now = System.currentTimeMillis();
        //计算剩余水量
        water = Math.max(0, water - ((now - timeStamp)/1000) * rate);
        //重置最新时间
        timeStamp = now;

        if ((water + 1) < capacity){
            //新增请求, 并且容量未满,
            water++;
            return true;
        } else {
            // 水满,拒绝请求
            return false;
        }
    }
}
