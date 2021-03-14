## 基础

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
       callable<>
 FutureTask 实现了接口Runnable Future接口
×××××××××××
本质上都是创建Thread对象 调用 start方法
    
```

### 常见的线程的方法

```java
sleep() 让其他
    
    
yield（）线程离开或者让出CPU 进入等待队列 进入线程的就绪态
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

### 线程“打断”  中级

```java
interrupt() 只是设置终端标志位
isInterrupted() 查询是否被设置过标志位
static interrupted() 查询“当前”线程标志位，并重置标志位
```





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

















 



