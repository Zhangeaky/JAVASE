package test.JUC.AQS.ReadwriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Analysis {

    public static void main(String[] args) {

        /* 默认非公平锁 */
        ReentrantReadWriteLock obj = new ReentrantReadWriteLock(true);
        Lock read = obj.readLock();






    }

}
