package com.sdyin.dsag.arithmetic.mine.ratelimit;

/**
 * 限流算法-令牌桶
 */
public class TokenBucket {

    // 当前时间
    public long timeStamp = System.currentTimeMillis();
    // 桶的容量
    public long capacity;
    // 令牌放入速度
    public long rate;
    // 当前令牌数量
    public long tokens;

    public boolean limit(){
        long now = System.currentTimeMillis();
        // 匀速添加令牌
        tokens = Math.min(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;

        if(tokens < 1) {
            // 若不到1个令牌,则拒绝
            return false;
        } else {
            // 还有令牌，请求通过
            tokens = tokens - 1;
            return true;
        }

    }
}
