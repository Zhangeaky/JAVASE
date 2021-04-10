package test.JUC.countdownLatchTest;

import java.util.concurrent.CountDownLatch;

public class BuyMovieTicketTask implements Runnable{


    private CountDownLatch countDownLatch;
    public BuyMovieTicketTask(CountDownLatch cc){
        this.countDownLatch = cc;
    }

    @Override
    public void run() {

        try{
            System.out.println(CountdownlatchDemo.printDate()+Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(CountdownlatchDemo.printDate()+Thread.currentThread().getName()+"Tickets have been bought!");

        }   catch (InterruptedException e){
            e.printStackTrace();

        }   finally {
            if(this.countDownLatch!=null){
                countDownLatch.countDown();
            }
        }
    }
}
