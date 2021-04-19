package top.zhangeaky.juc;

import java.io.IOException;

public class luanxv {
    private int num = 8;

    luanxv() {
        new Thread(() -> {
            System.out.println(num);
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new luanxv();
        System.in.read();
    }


}

class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            System.out.println("线程启动");
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
