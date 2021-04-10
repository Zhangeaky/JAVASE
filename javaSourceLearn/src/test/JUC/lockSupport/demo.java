package test.JUC.lockSupport;

import java.util.concurrent.locks.LockSupport;

public class demo {

    public static void Do(){

        System.out.println(Thread.currentThread().getName()+" 正在执行！ ");
        LockSupport.park();

    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            demo.Do();
        });

        Thread t2 =  new Thread(() -> {
            demo.Do();
        });

        t1.start();
        t2.start();
        for(int i=0;i<10;i++){
            System.out.print("" +1);
            Thread.sleep(1000);
        }

        LockSupport.unpark(t1);
        LockSupport.unpark(t2);


    }



}
