package test.JUC.AQS.countdownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Analysis {

    public static void run(CountDownLatch cc) throws InterruptedException {

        for (int i = 0;i<5;i++){
            Thread.sleep(1000);
            System.out.println(i);
        }
        cc.countDown();
        //cc.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cc = new CountDownLatch(2);
        System.out.println("主线程...");
        //静态内部类sync
        Thread.sleep(1000);

        new Thread(()->{
            try {
                Analysis.run(cc);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("----");
        cc.await(15, TimeUnit.SECONDS);
        System.out.println("----");

    }
}
