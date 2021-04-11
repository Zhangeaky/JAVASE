package test.JUC.AQS.semaphore;

import java.util.concurrent.Semaphore;

public class demo {

    /* 同样可以通过 true 和 false 来选则是否为公平模式
    *
    * Semaphore 内部有两个类 fairSync 和 unfairSync 用于实现抢占操作
    *
    * */
    private static Semaphore semaphore = new Semaphore(1,false);


    static class testThread implements Runnable{

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" 拿锁 ");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" 正在执行... ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+" 释放！ ");
                semaphore.release();

            }

        }
    }

    public static void main(String[] args) {

        new Thread(new demo.testThread()).start();
        new Thread(new demo.testThread()).start();
        new Thread(new demo.testThread()).start();
        new Thread(new demo.testThread()).start();


    }





}
