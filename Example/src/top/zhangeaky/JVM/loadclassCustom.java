package top.zhangeaky.JVM;

public class loadclassCustom {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = loadclassCustom.class.getClassLoader().loadClass("top.zhangeaky.JVM.show");

        System.out.println(aClass.getName());
        System.out.println(aClass.getMethods());
    }
}
