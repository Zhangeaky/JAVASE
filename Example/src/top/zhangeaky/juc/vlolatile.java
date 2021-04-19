package top.zhangeaky.juc;

public class vlolatile extends Thread {

    static private volatile int count;
    //static private  int count;

    @Override
    public void run() {
        synchronized (vlolatile.class) {

            while (count < 2000) {
                //System.out.println("here is "+Thread.currentThread().getName());

                count++;
                System.out.println(Thread.currentThread().getName() + " count: " + count);

            }
        }


    }

    public static void main(String[] args) throws Exception {

        vlolatile vv = new vlolatile();
        vlolatile vvv = new vlolatile();
        vv.start();
        vvv.start();
        System.in.read();

    }
}
