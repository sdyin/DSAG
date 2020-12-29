package com.sdyin.dsag.arithmetic.thread;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/12/29$ 上午10:45$
 */
public class ProdConsume_Sync {

    public static void main(String[] args) throws InterruptedException {
        Resource4 resource = new Resource4();
        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    resource.prod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"prod").start();


        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    resource.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"con").start();

        Thread.sleep(2000);
        System.out.println("执行结束");
    }
}

class Resource4{
    public volatile int num = 0;
    public String resource = "resource";
    String p = "12345";
    String c = "abcde";
    int pIndex = 0;
    int cIndex = 0;

    public void prod() throws InterruptedException {
        synchronized (resource){
            while(num == 1){
                resource.wait();
            }
            System.out.println(p.charAt(pIndex));
            pIndex++;
            num++;
            resource.notifyAll();
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (resource){
            while (num == 0){
                resource.wait();
            }
            System.out.println(c.charAt(cIndex));
            cIndex++;
            num--;
            resource.notifyAll();
        }
    }
}


