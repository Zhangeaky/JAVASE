package test.JUC.CylicBarrierTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test1 implements Runnable{

    public static CyclicBarrier cc;

    public void setCc(CyclicBarrier cc) {
        this.cc = cc;
    }

    @Override
    public void run() {

        try {
            this.cc.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("pass!!!!!!"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        CyclicBarrier cc = new CyclicBarrier(5, ()->{
            System.out.println("发车放行！！！"+Thread.currentThread().getName());
        });
        Test1.cc = cc;

        new Thread(new Test1()).start();
        new Thread(new Test1()).start();
        new Thread(new Test1()).start();
        new Thread(new Test1()).start();
        new Thread(new Test1()).start();


    }

}
