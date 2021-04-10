package test.JUC.semaphore;

import java.util.concurrent.Semaphore;

public class demo {


    private static Semaphore semaphore = new Semaphore(2);

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
