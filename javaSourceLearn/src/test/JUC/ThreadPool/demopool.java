package test.JUC.ThreadPool;

import sun.nio.ch.ThreadPool;

import java.io.IOException;
import java.util.concurrent.*;

public class demopool implements Runnable{

    private int id;
    demopool(int i){
        this.id = i;

    }

    @Override
    public String toString() {
        return "demopool{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" Task"+id);

        try{
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        /* Executor 执行方法 */
        /*    |
        /* ExecutorService  生命周期方法 */


        /*
        * corePoolSize : 核心线程
        * */


        ThreadPoolExecutor tp = new ThreadPoolExecutor(
                2,/* 核心线程数 永远存活不会归还给OS 即使空闲也不会交还给操作系统 */
                4,
                60, /* 空闲的线程资源交还给OS 空闲时间 */
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),/* 最多只能装载4个最大任务 */
                Executors.defaultThreadFactory(),/* ThreadFacry 产生线程 */
                new myrejection()/* 拒绝策略
                 *任务来的时候 使用核心线程处理
                 *核心线程占用满了,加入任务队列
                 *任务队列满了启动 非核心线程 处理
                 * 达到线程池 最大的核心数的时候 启用拒绝策略
                 1. Abort 抛出异常
                 2. discard 扔掉不抛异常
                 3.DiscardOlderst 扔掉排队时间最久的
                 4. CallerRuns 调用者处理任务
                 */
                );

        for (int i=0;i<8;i++){

            tp.execute(new demopool(i));


        }
        System.out.println(tp.getQueue());
        tp.execute(new demopool(100));

        tp.shutdown();

        /* 线程池的工厂 产生线程池*/
        /* 只有一个线程的线程池 可以保证 多线程任务是循序执行的 保证任务顺序
        *
        * 为什么要有单线程的线程池?
        * 1. 有任务队列
        * 2. 线程池的生命周期提供
        * */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /*
        * 没有核心线程数
        * 最大的线程数量是INTEGER MAX
        * keepAlive 60s 缓存在池子里面
        * SynchronousQueue 来一个走一个
        * */
        ExecutorService executorService1 = Executors.newCachedThreadPool();

        /*
        *  所有的线程都是核心线程 最大线程数 == 核心线程数
        *
        *
        * */
        ExecutorService fixedExecutorService2 = Executors.newFixedThreadPool(3);

        /* fixed 和 cached 怎么选择 */


        /*
        * 定时任务
        * 定时器框架 quartz
        * DelayedWorkQueue
        *
        * */
        Executors.newScheduledThreadPool(1);

        /*  线程池中的 每一个线程有自己单独的任务队列
        *
        *
        * */
        ExecutorService executorService2 = Executors.newWorkStealingPool(3);


    }


}
