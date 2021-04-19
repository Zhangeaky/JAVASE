package top.zhangeaky.SE;

import top.zhangeaky.entity.player;

import java.lang.reflect.Constructor;

public class reflection extends person implements eat, breath, drink {


    public static void main(String[] args) throws ClassNotFoundException, Exception {

        //player p  = new player("james","nets",13);
        Class cla = player.class;
        System.out.println("------");
        Class clazz = Class.forName("top.zhangeaky.entity.player");
        System.out.println(clazz.isInterface());
        System.out.println("------");
        Class clazz1 = Class.forName("top.zhangeaky.SE.reflection");
        System.out.println(clazz1.getSuperclass());
        for (Class ele : clazz1.getInterfaces()) {
            System.out.println(ele);
        }
        System.out.println(clazz1.getInterfaces());
        System.out.println("~~~~~~~");
        Class<player> nn = player.class;
        Constructor<player> constructor = nn.getDeclaredConstructor();
        constructor.setAccessible(true);

        player p = nn.newInstance();

    }


}

interface eat {
}

interface drink {
}

interface breath {
}

class person {
}
