package top.zhangeaky;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{

            System.out.println("线程状态： "+Thread.currentThread().getState());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
        System.out.println(t1.isInterrupted());

    }
}
