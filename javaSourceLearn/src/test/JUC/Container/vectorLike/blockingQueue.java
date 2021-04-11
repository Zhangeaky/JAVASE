package test.JUC.Container.vectorLike;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class blockingQueue {

    public static void run(ArrayBlockingQueue<Integer> bq) throws InterruptedException {
        bq.take();

    }

    public static void test(ArrayBlockingQueue<Integer> abq) throws InterruptedException {

        abq.put(1);
        abq.put(2);
        abq.put(3);

        abq.take();

    }

    public static void main(String[] args) throws InterruptedException {
        /*
        * offer add peek poll
        *
        * 实现 BlockingQueue接口
        * put
        * take 阻塞方法 实现生产者 消费者的模型 MQ消息队列的基础
        * */
        LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<>();
        lbq.offer(1);
        lbq.put(1);

        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(1);
        abq.put(1);
        new Thread((  )->{

            try {
                Thread.sleep(5000);
                run(abq);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        abq.put(1);


        System.out.println("end!");
    }
}
