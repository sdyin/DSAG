package com.sdyin.dsag.arithmetic.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 线程交替执行打印A1B2C3...
 * @Author liuye
 * @Date 2020/10/20 11:03
 **/
public class ThreadAlternate {

    static Thread t1;
    static Thread t2;

    /**
     * LockSupport 方式,
     * 此种方式要注意 park和 unpark 方法顺序,不能都是park先，不然执行不到unpark 就都会阻塞。
     */
    private static void byLockSupport(){
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();
        t1 = new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
                //注意unpark是类似颁发一个许可证permit，当该线程有许可证时,park会直接执行响应，并消耗一个permit
                //如果该线程没有许可证permit，调用park方法会阻塞直至被唤醒。
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(() -> {
            for (int i = 0; i < num.length; i++) {
                LockSupport.park();
                System.out.println(num[i]);
                LockSupport.unpark(t1);
            }
        },"t2");
        System.out.println("lockSupport 方式");
        t1.start();
        t2.start();
    }

    static String T1 = "t1";
    static String T2 = "t2";
    //先默认定义T1准备运行，而且要设置volatile线程可见,此处T1,T2相当于标识
    static volatile String up = T1;
    /**
     * 使用CAS自旋锁 + volatile 实现
     */
    private static void byCASAndVolatile(){
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();
        new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                while (up == T2){
                }
                System.out.println(str[i]);
                up = T2;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < num.length; i++) {
                while (up == T1){
                }
                System.out.println(num[i]);
                up = T1;
            }
        }).start();

    }

    //定义一个原子性的对象
    static AtomicInteger thredNo = new AtomicInteger(1);
    /**
     * 使用原子类方式
     */
    private static void byAtomic(){
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();
        new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                while (thredNo.get() != 1){
                }
                System.out.println(str[i]);
                thredNo.set(2);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < num.length; i++) {
                while (thredNo.get() != 2){
                }
                System.out.println(num[i]);
                thredNo.set(1);
            }
        }).start();
    }

    /**
     * 使用wait/notify方式
     */
    private static void bySynchNotify(){
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();
        String lock = "lock";
        new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                synchronized (lock){
                    System.out.println(str[i]);
                    try {
                        lock.wait();
                        lock.notify();
                    } catch (InterruptedException e) {

                    }
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < num.length; i++) {
                synchronized (lock){
                    System.out.println(num[i]);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static Lock lock = new ReentrantLock();

    /**
     * 使用 ReentrantLock 方式
     */
    private static void byLock(){
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                lock.lock();
                System.out.println(str[i]);
                try {
                    condition.await();
                    condition.signal();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                lock.lock();
                System.out.println(num[i]);
                try {
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1);
    /**
     * 通过阻塞队列方式
     */
    private static void byBlockingQueue(){
        char[] num = "1234567".toCharArray();
        char[] str = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (int i = 0; i < str.length; i++) {
                try {
                    bq.put(i);
                    System.out.println(str[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < num.length; i++) {
                try {
                    bq.take();
                    System.out.println(num[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }



    public static void main(String[] args) {
        //测试lockSupport方式
        //byLockSupport();
        //测试volatile方式
        //byCASAndVolatile();
        //测试原子类方式
        //byAtomic();
        //测试wait-notify 方式
        //bySynchNotify();
        //测试lock方式
        //byLock();
        //测试阻塞队列方式
        byBlockingQueue();
    }

}


