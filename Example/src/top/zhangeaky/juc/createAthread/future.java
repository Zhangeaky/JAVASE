package top.zhangeaky.juc.createAthread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class future implements Callable<String> {

    @Override
    public String call() throws Exception {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"is "+thread.getState());
        return "张毅凯";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task = new FutureTask<String>(new future());
        //task.run();
        String s = task.get();
        System.out.println(s);

    }
}
