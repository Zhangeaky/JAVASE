package test.AQS;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(3);
        hs.add(5);
        hs.add(88);
        hs.add(0);
        hs.add(4);
        hs.forEach(System.out::println);
        System.out.println("-----");

        System.out.println(hs.size());
        LinkedHashSet<Integer> lh = new LinkedHashSet<>();
        lh.add(1);
        lh.add(2);
    }
}
