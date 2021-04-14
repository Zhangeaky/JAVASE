package test.proxy.instance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {




    public static void main(String[] args) {

        helloImpl hh = new helloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hh);

        /* 静态工厂方法 */
        hello proxyhello =  (hello)Proxy.newProxyInstance(helloImpl.class.getClassLoader(),
                helloImpl.class.getInterfaces(), handler);
        proxyhello.sayhello();

    }




}

interface hello{
    void sayhello();
}

/* 目标类必须实现接口 */
class helloImpl implements hello{
    @Override
    public void sayhello() {
        System.out.println("hello proxy");
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法开始!!!");
        Object invoke = method.invoke(object, args);
        System.out.println("方法结束!!!");
        return invoke;
    }
}
