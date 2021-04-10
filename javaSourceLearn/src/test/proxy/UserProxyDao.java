package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxyDao {

    private Object target;// 维护一个目标对象

    public UserProxyDao(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务--动态代理");
                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("提交事务--动态代理");
                        return null;
                    }
                });
    }


    public static void main(String[] args) {
//            //目标对象
//            IuserDao target = new userDao();
//            System.out.println(target.getClass());  //输出目标对象信息
//            UserProxyDao proxy = ( userDao) (new UserProxyDao(target)).getProxyInstance();
//            System.out.println(proxy.getClass());  //输出代理对象信息
//            proxy.save();  //执行代理方法

    }


}
