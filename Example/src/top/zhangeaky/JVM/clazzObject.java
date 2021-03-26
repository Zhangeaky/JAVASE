package top.zhangeaky.JVM;
import top.zhangeaky.entity.player;
public class clazzObject {

    public static void main(String[] args) {

        player pp = new player();
        Class<player> playerClass = player.class;

        Class<? extends player> aClass = pp.getClass();
        System.out.println(aClass==playerClass);



    }
}
