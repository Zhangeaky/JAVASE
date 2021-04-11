package test.JUC.ThreadPool;

import java.util.concurrent.ForkJoinPool;

public class forkJoinPool {

    public static void main(String[] args) {

        /* 适合将大任务切分成小任务执行 */

        ForkJoinPool fjp = new ForkJoinPool();




    }



}
