package test.proxy.cglibTest;

public class test {
    public static void main(String[] args) {
        useDao target = new useDao();
        System.out.println(target.getClass());
        //代理对象
        useDao proxy = (useDao) new proxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
    }
}
