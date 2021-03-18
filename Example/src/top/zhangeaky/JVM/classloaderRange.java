package top.zhangeaky.JVM;

public class classloaderRange {

    public static void main(String[] args) {
        System.out.println("---------");
        String pathboot = System.getProperty("sun.boot.class.path");
        System.out.println(pathboot.replaceAll(":",System.lineSeparator()));

        System.out.println("---------");
        String extpath = System.getProperty("java.ext.dirs");
        System.out.println(extpath.replaceAll(":",System.lineSeparator()));

        System.out.println("---------");
        String apppath = System.getProperty("java.class.path");
        System.out.println(apppath.replaceAll(":",System.lineSeparator()));
        System.out.println(classloaderRange.class.getClassLoader());

    }
}
