package test.JUC.AQS.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class nonFairDemo {


    public static void main(String[] args) {
        /* 默认是非公平抢占 */
        ReentrantLock rr = new ReentrantLock();

        rr.lock();
        rr.unlock();
    }
}
