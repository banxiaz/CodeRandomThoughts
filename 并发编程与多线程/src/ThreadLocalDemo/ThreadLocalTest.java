package ThreadLocalDemo;

import java.util.function.Supplier;

public class ThreadLocalTest {
    public static void main(String[] args) {
        //ThreadLoal变量，线程局部变量，同一个 ThreadLocal 所包含的对象，在不同的 Thread 中有不同的副本
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<String>() {
            @Override
            public String get() {
                return Thread.currentThread().getName();
            }
        });

        System.out.println(threadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
            }
        }).start();


    }
}
