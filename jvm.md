### JVM基础

![image-20210314153451012](/home/zhangeaky/.config/Typora/typora-user-images/image-20210314153451012.png)

解释编译并行

scala groovy 等语言可以跑在JVM

jvm 与 java语言无关

class文件 ----> jvm

jvm是一种规范 java13

- 字节码指令集
- 内存管理

**jvm实现**

- Hotspot
- Microsoft VM
- J9

- TaoBao VM: HotSpot 深度定制版

- azul zing 垃圾回收

JRE ： jvm + core lib（核心类库）

JDK：jre + development kit

### 编译 加载 初始化

#### loading

```
class
```



#### linking

验证

准备

给静态变量赋默认值

解析

符号引用转化为内存地址



初始化

静态变量初始化

#### 类加载器

每一个类都是被类加载器classloader加载进内存的

class 文件加载到内存之后

		1. class 内存映射
  		2. 生成class 类对象，通过该对象访问class文件 指向上面的内存



![image-20210318113009199](/home/zhangeaky/.config/Typora/typora-user-images/image-20210318113009199.png)



什么时候需要自己去加载一个类？

#### 如何自定义类加载器？

继承classLoader 类 重写findclass方法

#### 编译器

JIT

混合模式：热点代码编译成本地代码 结合  解释器

为什么不直接编译为本地代码？解释器效率高



### initial

#### 指令重排

```java
package com.mashibing.dp.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE; //JIT

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Mgr06.class) {
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}

```

### JMM java 内存模型

#### 1. 硬件层并发优化 基础

```java

多线程数据一致性的硬件层面支持  bus lock 老的方式
    一致性协议 缓存锁+总线锁
    有一些数据
    


















```

