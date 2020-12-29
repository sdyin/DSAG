package com.sdyin.dsag.arithmetic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/12/29$ 上午11:12$
 */
public class ProdConsume_Lock {

    public static void main(String[] args) {
        ResourceLock resourceLock = new ResourceLock();
        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                resourceLock.prod();
            }
        },"pro").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                resourceLock.consumer();
            }
        },"consumer").start();
    }

}

class ResourceLock{
    public volatile int num = 0;
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    String p = "12345";
    String c = "abcde";
    int pIndex = 0;
    int cIndex = 0;

    public void prod(){
        try {
            lock.lock();
            while (num != 0) {
                condition.await();
            }
            System.out.println(p.charAt(pIndex));
            num++;
            pIndex++;
            condition.signalAll();
        }catch(InterruptedException e){
            System.out.println(e);
        } finally {
            lock.unlock();
        }

    }

    public void consumer(){
        try {
            lock.lock();
            while (num != 1) {
                condition.await();
            }
            System.out.println(c.charAt(cIndex));
            cIndex++;
            num--;
            condition.signalAll();
        }catch (InterruptedException e){
            System.out.println(e);
        } finally {
            lock.unlock();
        }

    }
}
