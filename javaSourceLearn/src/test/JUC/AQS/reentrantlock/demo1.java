package test.JUC.AQS.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {


    public static void run(Lock lock){
        lock.lock();
    }

    public static void main(String[] args) throws InterruptedException {

        /*
        * 默认非公平锁
        * 构造函数传入参数 true:公平 false: 不公平
        * */

        ReentrantLock lock = new ReentrantLock(true);

        new Thread(()->{
            run(lock);
        }).start();
        Thread.sleep(3000);

        lock.lock();

//        i++;

        lock.unlock();

    }




}
