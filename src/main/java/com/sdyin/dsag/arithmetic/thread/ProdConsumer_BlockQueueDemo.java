package com.sdyin.dsag.arithmetic.thread;

import org.springframework.util.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 生产-消费者模型 阻塞队列版
 * @Author: liuye
 * @time: 2020/9/23$ 下午11:16$
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println("生产队列启动");
            try {
                myResource.prod();
            } catch (InterruptedException e) {
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println("消费队列启动");
            try {
                myResource.consumer();
            } catch (InterruptedException e) {
            }
        }, "consumer").start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myResource.stop();
        System.out.println("停止执行");
    }
}


class MyResource{

    private volatile boolean flag = true;//默认开启

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (flag){
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 1L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName() + "生产数据" + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "生产数据" + data + "失败");
            }
            Thread.sleep(100);
        }

        System.out.println("flag = false,停止生产");
    }

    public void consumer() throws InterruptedException {
        String data = null;
        while(flag){
            data = blockingQueue.poll(1L,TimeUnit.SECONDS);
            if(StringUtils.isEmpty(data)){
                System.out.println("超时1s未获取到数据");
                //消费超时后就停止执行，不要一直阻塞
                flag = false;
                return;
            }else{
                System.out.println(Thread.currentThread().getName() + "消费数据" + data + "成功");
            }
        }
    }

    public void stop(){
        this.flag = false;
    }

}