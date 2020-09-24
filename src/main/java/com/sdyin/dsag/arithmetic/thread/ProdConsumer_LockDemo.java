package com.sdyin.dsag.arithmetic.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 生产者消费者模型——lock版本
 * @Author liuye
 * @Date 2020/9/24 17:35
 **/
public class ProdConsumer_LockDemo {

    public static void main(String[] args) throws Exception {
        Resource1 resource1 = new Resource1();

        new Thread(() -> {
            System.out.println("启动生产者线程");
            try {
                Thread.sleep(100);
                for (int i = 0; i < 5; i++) {
                    resource1.prod();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    resource1.consumer();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        Thread.sleep(4000);
        System.out.println("主线程执行结束");
    }
}


class Resource1 {

    public volatile int num = 0;

    public Lock lock = new ReentrantLock();

    public Condition condition = lock.newCondition();


    public void prod() throws InterruptedException {
        lock.lock();
        while (num != 0) {
            condition.await();
        }
        try {
            System.out.println(Thread.currentThread().getName() + "开始生产");
            Thread.sleep(100);
            num++;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void consumer() throws InterruptedException {
        lock.lock();
        while (num != 1) {
            condition.await();
        }
        try {
            System.out.println(Thread.currentThread().getName() + "开始消费");
            Thread.sleep(100);
            num--;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
