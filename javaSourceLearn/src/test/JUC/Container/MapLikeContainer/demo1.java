package test.JUC.Container.MapLikeContainer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* 这里分析的是实现Map的容器  */
public class demo1 {

    public static void main(String[] args) {
        /*  以下所有的容器都不是相互替代的关系 各自有各自在具体场景下的 使用优势 */

        /* 第一阶段 */
        /* 自带锁  synchronized
        *  jdk 1.2 遗留下来的产物 好像不在更新了
        * */
        Hashtable<String,String> tt = new Hashtable<>();

        /* 线程不安全 */
        HashMap<String,String> hh = new HashMap<>();

        /* 第二阶段   */
        /* 在本质上和hashtable 区别不是很大 */
        Map<String, String> stringStringMap = Collections.synchronizedMap(hh);

        /* 并发插入效率并不一定比其他容器要高 读取的效率高 */
        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>();

        chm.put("name", "zhangeaky");      

        /* 为什么没有 conrrentTreeMap
        * CAS 在数中操作比较复杂 所以转用tiao表实现
        *  */
        ConcurrentSkipListMap<String,String> ss = new ConcurrentSkipListMap<>();


    }




}
