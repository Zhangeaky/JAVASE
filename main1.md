## java

### jvm

```
是一种规范，用于执行字节码。
jMM
栈：
堆：
```

### jdk

```

```

### 变量

- 类的基本结构

```java
/*局部变量与成员变量*/
/*局部变量没有默认值
成员变量有默认值*/
public Student{
    /*static 关键字修饰的变量是属于类的公共变量，所有的实例共享
     该类型的变量在对象创建之前完成初始化，在类被载入之前完成初始化
    */
    
    /*静态变量不能定义在方法内部，只能在类内部方法的外部定义*/
    static String school;
    int age; /*默认值为零*/
    String name; /**/
    long number;
    
    public Student(int age,){
        /*this是当前对象的引用，记录着当前对象在堆区的首地址 */
        age = age;
        this.age = age;
    }
    
    /*工具类中的方法经常被定义为静态方法*/
    /*静态可以被非静态的方法调用*/
    /*静态方法内部不能应用任何 super和this关键字*/
    public static void walk(){
        
    }
    
    public void study(){}/*方法区*/
    
}

public class demo{
    public static void main(String[] args){
        
    }
}

/*
堆区
引用变量：
引用不能和指针一样进加减运算，他只能进行赋值运算。

栈区

方法区：
"类"的信息、static 变量、字符串常量

*/
```

静态变量**不能**定义在方法的内部

```java
/*不被允许*/
public static void walk(){
    static int itenrary;
}
public void study(){
    static int times;
}
```

### 数组

> 引用类型

```java
数组的默认初始化： 默认值取决与定义的数组的类型
    int[] arry = new arry[5];
```

### 包装类

> 将基本的数据类型封装到一个类中，包含属性和方法

*装箱*：

```java
Integer i = Integer.valueOf(100); //返回引用值
```

*拆箱*:

```java
new Integer(100).intvalue(); // 返回普通值
```



Integer valueof()方法和 invalue方法的源码考察

```java
int i = 100;
Integer i1 = 100;
Integer i2 = 100;
Integer i3 = 200;
Integer i4 = 200;
/*
Integer 实现申请了127个Integer大小的数组作为缓存。
*/
System.out.println( i1 == i2 ); //true
System.out.println( i3 == i4 ); //false
```

- String

  字符串本身是一个字符数组。

  String 类使用fianl 修饰 不可以被继承了。

  常量池 jdk1.7 后放置在堆区中。jdk1.8后永久区被移除

  双引号括起来的字符串就是一个对象。“abc”字符串自从诞生，就不会变了，都存在字符串常量池。

  凡是双引号括起来的字符串都在常量池，new 出来的对像都在堆区

```java
/*String 属性的值
---final 类型说明 引用关系不能被改变，拼接、剪裁操作都会产生新的对象

*/

private final char[] value;
/*直接赋值创建的对象是在常量池中，自动进入常量池*/
String str = "abc";

/* "abc"字符串对象已经存在与常量池、但是“xyz”会在常量池中新建出来 
	拼接出来的新的字符串也会出现在常量池中
*/
String str1 = "abc"+"xyz"；
/*通过new 创建的对象实在堆区内存，需要手动进入常量池*/
String str_ = new String("abc");
```

​	equals（）方法,比较对象中值是否相等。一一比较字符数组的每一个字符。String类中的equals()方法对Object中的equals()进行了重写。

```java

str.equals(str_);
str.hashcode();
str.charAt(0);//获取第0个字符
//拼接
str.concat();
```

intern()

```

```



返回

```java
String a = "abc"
String b = "ced"
String c = "adcde"
String str = new String("abc");
```

hashcode()

```java

```

- StringBuffer

  > 线程安全，效率低

```java
StringBuffer sb = new StringBuffer（）；
sb.append(1);
sb.append(true);
sb.append("haha");
```

length 和 capacity 的区别

- StringBuilder

  > 线程不安全

```




```

- enum 枚举

  > 相当于对象已经提前创建完毕了
  >
  > 当你需要定义一组常量的时候，可以使用枚举类

```java
public enum NETS{
    
    KD(7), KI(11);
    
    NETS(int i){
    }
    private int number;
}
```

- Object 类

hashcode（）方法

```java
hashcode()   
```

equals()

```java

```

toString()

```java
/*对象的地址*/
```

notify()

```

```

notifyAll()

```

```

wait()

```

```

waitlong()

```

```

finalize()

```java
/* 垃圾回收，若对象存在应用就不会进行垃圾回收。*/
```





- 
- 反射

