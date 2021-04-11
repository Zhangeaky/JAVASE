package test.JUC.Container.copyonwriteList;

import java.util.concurrent.CopyOnWriteArrayList;

public class demo1 {

    public static void main(String[] args) {

        /* 写时复制
        *
        * 读的时候不加锁
        * 写的时候加锁
        * */

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();



    }

}
