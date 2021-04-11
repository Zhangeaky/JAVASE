package test.JUC.ThreadPool;

import java.util.concurrent.CompletableFuture;

public class completablefuture {

    public static void run1(){
        System.out.println(1);
    }

    public static void run2(){
        System.out.println(2);
    }

    public static void run3(){
        System.out.println(3);
    }

    public static void main(String[] args) {

        //CompletableFuture.allOf(run1(),run2(),run3()).join();

    }


}
