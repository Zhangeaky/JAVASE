package test.JUC.ThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class myrejection implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {


        System.out.println("zyk:我拒绝你");
        for (int i=0;i<10;i++){
            niha:
            break niha;
        }


    }
}
