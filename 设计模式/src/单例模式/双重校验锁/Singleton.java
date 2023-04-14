package 单例模式.双重校验锁;

public class Singleton {
    private volatile static Singleton instance; //保证可见性和禁止指令重排序

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            //多个线程可以同时到达这里，但是只有一个线程会获得锁
            synchronized (Singleton.class) {
                //如果不加双重校验，第一批同时到达的线程获取到锁后会重复实例化对象
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/*
volatile可以防止指令重排序，如果不加volatile，由于instance = new Singleton()并不是原子操作，创建一个对象实例需要三个步骤。

1. 在堆上分配对象内存空间
2. 调用构造器方法，执行初始化
3. 将对象引用赋值给变量
Java指令重排序不会改变单线程下的执行结果，但是在多线程中会带来一些问题。
步骤2和步骤3不存在数据依赖关系，所以可能发生重排序，1->3->2，假如线程1在执行完3后，线程2被调度判断对象不为null所以直接访问对象了
但是此时对象还未初始化完成，线程2的访问会发生异常。即多线程环境下就可能将一个未初始化的对象引用暴露出来，从而导致不可预料的结果。

原文链接：https://blog.csdn.net/weixin_42385705/article/details/105900006
 */
