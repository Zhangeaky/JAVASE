package test.JUC.ThreadPool;

import java.util.concurrent.*;

public class demo1 {

    public static void run() throws ExecutionException, InterruptedException {

        /* Future Runnable */
        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            System.out.println(Thread.currentThread().getName()+" sleep... ");
            Thread.sleep(5000);
            return 3;

        });

        new Thread(task).start();

        System.out.println("return" + task.get());



    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Thread.currentThread().getName()+"主线程...");

        /* */
        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        };



        ExecutorService executorService = Executors.newCachedThreadPool();
        /* 存储执行结果  */
        Future<Integer> submit = executorService.submit(c);
        System.out.println(submit.get());

        executorService.shutdown();

        run();



    }
}
