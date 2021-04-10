package test.JUC.ReadwriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

    private static final int COUNT = 5;

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    
    private void handleRead(ReentrantReadWriteLock.ReadLock lock) throws InterruptedException {

        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" 读操作 " );
            Thread.sleep(1000);

        }finally {
            lock.unlock();
        }

    }

    private void  handlewrite(ReentrantReadWriteLock.WriteLock lock) throws InterruptedException {
        try{
            lock.lock();
            System.out.println("写操作--------");
            Thread.sleep(1000);
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        final Demo dd = new Demo();

        Runnable readtask = ()->{

            try{
                dd.handleRead(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writetask = ()->{

            try {
                dd.handlewrite(writeLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        for (int i=0;i<10000;i++){
            new Thread(readtask).start();
        }
        for(int i=0;i<1;i++){
            new Thread(writetask).start();
        }


    }


}
