package test.JUC.threadlocal;

public class demo1 {

    public static void main(String[] args) {

        ThreadLocal<Integer> t = new ThreadLocal<>();


        t.set(3);

        Thread.currentThread();
    }
}
