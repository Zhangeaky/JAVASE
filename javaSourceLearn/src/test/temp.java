package test;
import java.util.HashMap;

public class temp {


    static void test(Object x){
        System.out.println(x.getClass());
        System.out.println((x instanceof Base));

    }
    public static void main(String[] args) {
        test(new Derived());

        HashMap<String,Integer> hashMap = new HashMap<>();

        hashMap.put("Harden",23);



        int h;
        String key = "Harden";
        System.out.println("Harden".hashCode());
        int i = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(i);
        int b =7;



    }
}

class Base{}
class Derived extends Base{}

