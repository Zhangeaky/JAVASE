package test.JUC.countdownLatchTest;

import java.util.concurrent.CountDownLatch;

public class BuyPopcornTask implements Runnable{

    private CountDownLatch countDownLatch;

    public BuyPopcornTask(CountDownLatch cc){
        this.countDownLatch = cc;
    }

    @Override
    public void run() {
        try{
            System.out.println(CountdownlatchDemo.printDate()+Thread.currentThread().getName()+"开始买爆米花！");
            Thread.sleep(5000);
            System.out.println(CountdownlatchDemo.printDate()+Thread.currentThread().getName()+"买到了爆米花！");

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(this.countDownLatch!=null){
                countDownLatch.countDown();
            }
        }
    }
}
