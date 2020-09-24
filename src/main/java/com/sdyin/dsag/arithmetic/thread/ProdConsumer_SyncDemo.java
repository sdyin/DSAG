package com.sdyin.dsag.arithmetic.thread;

/**
 * @Description 生产消费者模型-Synchronized 版本
 * @Author liuye
 * @Date 2020/9/24 11:11
 **/
public class ProdConsumer_SyncDemo {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        new Thread(() -> {
            System.out.println("生产者线程启动");
            try {
                Thread.sleep(100);
                for (int i = 0; i < 5; i++) {
                    resource.prod();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "prod").start();


        new Thread(() -> {
            System.out.println("消费者线程启动");

            try {
                Thread.sleep(100);
                for (int i = 0; i < 5; i++) {
                    resource.consumer();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        Thread.sleep(4000);

        System.out.println("主线程执行结束");
    }
}


class Resource {

    public volatile int num = 0;
    public String resource = "resource";

    public void prod() throws InterruptedException {
        synchronized (resource) {
            //防止虚假唤醒，所以wait操作放在 while循环中，
            // 被唤醒后会继续执行while条件判断，用if则不会再判断，而是往下走
            // 多个生产者和消费者模型下会有这种问题
            while (num != 0) {
                resource.wait();
            }
            System.out.println(Thread.currentThread().getName() + "开始生产");
            Thread.sleep(100);
            num++;
            resource.notifyAll();
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (resource) {
            while (num != 1) {
                resource.wait();
            }
            System.out.println(Thread.currentThread().getName() + "开始消费");
            Thread.sleep(100);
            num--;
            resource.notifyAll();
        }
    }


}
