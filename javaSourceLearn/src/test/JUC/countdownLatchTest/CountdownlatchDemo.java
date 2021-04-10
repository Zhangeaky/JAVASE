package test.JUC.countdownLatchTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownlatchDemo {

    public static void main(String[] args) {

        long now  = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try{

            executorService.execute(new BuyMovieTicketTask(countDownLatch));
            executorService.execute(new BuyPopcornTask(countDownLatch));
            countDownLatch.await();
            System.out.println("进场看电影");

        }catch(InterruptedException e){
            e.printStackTrace();

        }finally{
            executorService.shutdown();
        }




    }



    public static String printDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date())+" ";
    }

}

class test{

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println("---");

    }

}
