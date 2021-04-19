## 一、基础

### 进程与线程到底是什么？

```
资源分配的基本单位；线程是CPU调度的基本单位，多线程共享进程的资源；

线程切换（Context Switch）：进程在执行时，指令和数据从加载到CPU的寄存器中，指令的地址加载到PC中，当产生线程切换时，寄存器和PC中的数据被转移到Cache中，CPU的寄存器和PC加载其他线程的资源

Cpu密集型线程： 需要进行复杂的CPU计算
IO密集型线程： 频繁等待IO
```

### 线程数为多少的时候最合适？

```
与CPU的核数相关
根据实际情况做压测
CPU个数×期望CPU个数（1+W/C）W：线程等待时间 C：线程计算时间

如何计算W和C的值？
Profiler（性能测算工具）工具测算
```

### 线程创建的方法

```java
1. 创建类继承Thread  
2. implements Runnable 接口传入Thread有参构造
以上两中方法哪一种更优？
    接口方式更优，因为java不能实现多继承，一单继承了thread类就无法集成其他类，但是接口可以多重实现，并再继承其他类
    
3. 使用lambada表达式
4. 使用线程池
5. 实现 Callable<?>接口 + 线程池； 通过泛型控制返回值的类型 实现call（）方法，并提交给线程池 
   通过类 Future<?>: 异步传递返回值 其成员方法 get() 阻塞类型得到返回值
       
6. FututreTask<?> task = new FutureTask<?>( 实现callable的接口实现类 )
   (1) task.get() 获取返回值对象；
   (2) FutureTask 实现了接口Runnable Future接口
×××××××××××
本质上都是创建Thread对象 调用 start方法
    
```

### 常见的线程的方法

```java
java.lang.Thread
static sleep() 让当前的线程休眠指定的毫秒数。
wait() 方法
static yield（）线程离开或者让出CPU 进入等待队列 进入线程的就绪态
join()  在线程本地调用自己的join()方法是没有任何意义的。该方法是指，暂停t1线程的执行，转而到join()方法的t2线程执行，并在t2线程执行结束后再返回t1线程。  
```

### 线程状态 低级

```java
NEW：对象刚刚创建 还没有调用start方法的时候
RUNABLE： 就绪(还没轮到时间片)和正在运行（正在执行自己的时间片）--->平均负载 yield 方法
WAIT: 等待 自旋 JUC锁竞争
TIMED WAITING  定时唤醒 TimeUnit.SECOND.sleep()
BLOCKED  synchronized 竞争锁 只有经过操作系统调度才会进入blocked状态进入阻塞队列
TERMINATED run方法执行完毕
```

### 线程“打断” 中级

```java
interrupt() 只是设置终端标志位
isInterrupted() 查询是否被设置过标志位
static interrupted() 查询“当前”线程标志位，并重置标志位    
对正在sleep join wait 的线程进行interrupt 操作的时候，线程会抛出异常，并且自动复位标志位    
线程处于 Synchronized Lock 竞争锁的时候不会被interrrupt干扰
```

### 线程的结束 有可能 理解

```java

java.lang.thread
  
// 粗暴结束 以及为什么被废弃
stop() 方法 粗暴 
    释放所有的锁，容易产生数据不一致性的问题

suspend() 暂停的时候 锁不会被释放，容易产生死锁
resume()
    
//优雅的结束 特定场景下的    
volatile 标志位 不依赖于中间状态
    volatile running = true;
    
    while(running){
        
        sleep() //会阻塞
        
    }

interrupt() 设置标记位 更加优雅 同同样适用于在中间过程对状态不高的
//
```

## 二、 进阶

**volatile 修饰引用类型**  只能保证引用本身的可见性，而不能保证 内部字段的可见性。也就是说，当变量指向的引用变了的时候，才会在线程间可见，引用类型内部字段的改变是不可见的。这种情况相对少见，一般出现在面试题中。

还可以保证线程的有序性。

```java
class java{
    
    private static class A{
    
    private static boolean running =false;
    private static void m(){
        System.out.println("start");
        while(running){ }
        System.our.println("end");
    }  
}

private volatile static A a = new A();
    
    public static void main(String[] args){
        
        new Thread(java::m,"t1").start;
        sleep(1);
        a.running = false
    }
    
     
    
}
```

##### 缓存

```java
缓存行： cacheLine 64 B 大小
   缓存行和volatile没有关系 
   缓存一致性协议，同一个缓存行发生改变，会通知另一个CPU的相同缓存行
   缓存行越大，局部空间效率越高，但读取的时间慢
   缓存行越小，局部空间命中率越低，但读取时间快
    64 B 是一种折中
   
class java{
    public static long COUNT = 10 0000 0000L;
    
    private static class T{
        // private long p1,p2,p3,p4,p5,p6,p7;
        public long x = 0L;
        
    }
    public static T[] arr = new T[2];
    
    static {
        arr[0] = new T();
        arr[0] = new T();
    }
    
}

局部性原理：
    当我们读到一个数据的时候，很可能很快会读到相邻的值  空间局部性
    时间局部性
```

#### 2. 有序性

> 程序是按照顺序执行的吗？

为什么会存在乱序的现象？

CPU为了提高效率，前后两条语句没有依赖关系的时候，可能会进行指令优化和重排序。

##### 乱序存在的条件

as-if-serial（看上去是序列化）

不影响单线程最终一致性的情况下，可以乱序。

this 逸出 不要造构造方法里面开启线程。

```java
class{
    private int number = 8;
    constructor(){
        new Thread(()->{
            System.out.println(this.num)
        }).start; 
    }
}
output: 0
--------------
new #2<T>
dup
invokespecial
astore_1
return
```

#### 3.原子性

多线程访问共享数据的时候出现的不一致

原子操作：不能被打断，不能并发执行

即使是汇编语言，也有可能被其他线程所打断

java 8大原子操作

```java
public static void main(String[] args){
    
    n++;
    
}
```

上锁的本质:把并发编程序列化，使线程同步。上锁之后效率肯定会变低。

#### synchronized

synchronized 会保证可见性和原子性，使得主内存的数据永远是最新的。但不本保证有序性。

JVM没有要求synchronized的实现规范

```java

//锁定的是对象 o ，而不是代码
// 默认锁定的是 this
// 避免锁定 Integer String Long 。。。
synchronized(o){
    .....
}

void synchronized m(){
    
}

public sunchronized void m(){// T.class
    
}

```

##### 可重入

synchronized 必须是可重入的

```
同一个线程必须可以多次进入临界区
```

##### 异常会释放锁

##### 底层实现

```java
JDK 早期， 重量级锁 --- OS 操作系统锁
锁升级 提升原有的效率
synchronized(Object)
    markword 在第一个使用线程 添加 thread id 偏向锁
    如果有其他的线程征用，升级为自旋锁，自旋十次以后，升级为重量级锁（下CPU，将线程添加到后备队列，等待分配）。
    
    锁只能升级不能降级
```

*自旋锁和重量级锁的区别，以及使用场景*

```
自旋锁处于用户态，加锁和去锁的成本比较轻，没有获得锁的时候，处于自旋状态，消耗处理机资源。
重量级锁一旦被加上，没有获得锁的进程就会发生上下文切换，操作系统介入，会增加系统的压力，但是同样因此，没有获得锁的线程就会被放入内存，等待调度，不消耗计算资源。
因此在临界区执行时间比较长的情况下，且竞争线程多，提倡使用重量级锁，避免等待线程消耗处理机。
临界区执行时间短，竞争线程少，使用自旋锁。避免频繁的线程切换，使得操作系统不断介入。
```

**一些基本概念**

monitor 管程 --->锁（synchronized后面跟的东西）

critical section 临界区

### 线程安全

多线程并发访问的时候会出现数据安全问题。解决方式：

```java
/* */
synchronized(  ){
    
}
```

### 死锁

相互等待，是程序运行中的一种问题。

### 生产者与消费者

```

```

### 线程池

进程申请的系统资源最终是给线程使用的。

- 好处：

1. 重复利用已有的线程
2. 没有申请和销毁的开销
3. 可以进行合理管理，根据系统的负载调整大小，动态调整。

- 执行步骤

1. 如果核心线程数量没有满，则创建线程，并加入核心线程中，使得核心线程数加一。
2. 如果核心线程数已经满了，则查看阻塞队列是否有余量，若有余量则直接加入阻塞队列，没有余量，则之间创建线程并进行执行，该线程被视为核心线程之外的线程，会被根据keepalive时间来进行回收。
3. 查看线程池是否超出最大线程数量，若超过，则使用拒绝策略将其拒绝抛出异常。

- 线程池的分类：
- 核心线程池
- 拒绝策略
- 线程池的生命周期

```
RUNNIGN
SHUTDOWN 
STOP
TIDYING
TERMIATED 
```

- execute 方法

```java
 public void execute(Runnable var1) {
        if (var1 == null) {
            throw new NullPointerException();
        } else {
            /* 输入参数线程对象不为空 */
            
            /*原子操作，获取当前核心线程数量*/
            int var2 = this.ctl.get();
            /*第一步*/
            /*当前工作线程小于核心线程数，则创建线程，加入执行工作*/
            if (workerCountOf(var2) < this.corePoolSize) {
                
                if (this.addWorker(var1, true)) {
                    return;
                }
				//创建失败，核心数不变
                var2 = this.ctl.get();
            }
            
			/*第二步，若*/
            if (isRunning(var2) && this.workQueue.offer(var1)) {
                int var3 = this.ctl.get();
                if (!isRunning(var3) && this.remove(var1)) {
                    this.reject(var1);
                } else if (workerCountOf(var3) == 0) {
                    this.addWorker((Runnable)null, false);
                }
            } else if (!this.addWorker(var1, false)) {
                this.reject(var1);
            }

        }
    }
```

###  

















 



