package top.zhangeaky.JVM;

class superclass{


    static {
        System.out.println("super class init!");
    }

    public static int value = 123;
}

/* 对像的被动引用 */
public class initial extends superclass{

    static {
        System.out.println("subclass init!");
    }






}

class test{

    public static void main(String[] args) {
        superclass[] arr = new superclass[10];

    }
}
