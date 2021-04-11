package test.JUC.AQS.lockSupport;

import java.util.concurrent.locks.LockSupport;

public class demo2 extends Thread{

    demo2(String name){

        super(name);


    }
    public static Object lock = new Object();

    static demo2 t1 = new demo2("测试线程1");
    static demo2 t2 = new demo2("测试线程2");

    @Override
    public void run() {
        synchronized (lock){
            System.out.println(getName()+" 获得锁 开始执行... ");
            System.out.println("线程阻塞，等待唤醒...");
            LockSupport.park();

            if(Thread.currentThread().isInterrupted()){
                System.out.println(getName()+" 线程被中断 ");
            }
            System.out.println("线程被唤醒， 继续执行... ");
        }
        System.out.println("执行结束！");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("主线程");
        t1.start();

        //System.out.println(t1.getName()+" 启动 ");
        Thread.sleep(1000L);
        t2.start();
        //System.out.println(t2.getName()+" 启动 ");
        Thread.sleep(2000);
        System.out.println("中断线程 " + t1.getName());
        t1.interrupt();
        Thread.sleep(3000);
        System.out.println(t2.getName()+"唤醒线程");
        LockSupport.unpark(t2);
    }
}
