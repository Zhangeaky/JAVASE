package test.proxy;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class classtry {

    public static class player{

        private String name;
        private Integer age;

        public void shot(){
            System.out.println("shot !");
        }


    }


    public static int id=10;
    

    
    static {
        System.out.println("hello world");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        System.out.println(classtry.id);
        //Class<classtry> classtryClass = classtry.class;


        final Class<?> clazz = Class.forName("test.proxy.userDao");

        Method[] methods = clazz.getMethods();
        System.out.println("method: "+methods.length);
        for (Method method:methods
             ) {

            System.out.println(method);

        }
        System.out.println("----------");
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor cons:constructors
             ) {
            System.out.println(cons);
        }






    }
}


