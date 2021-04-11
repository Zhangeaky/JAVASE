package test.JUC.Container.vectorLike;

import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class demo1 {

    public static void main(String[] args) {

        /* Queu 和 List 的区别在哪里?
        * Queue 添加了许多对线程友好的api offer peek poll
        *
         */


        /* vector --> queue */
        Vector<Integer> vv = new Vector<>();

        ConcurrentLinkedQueue<Integer> qq = new ConcurrentLinkedQueue<>();







    }
}
