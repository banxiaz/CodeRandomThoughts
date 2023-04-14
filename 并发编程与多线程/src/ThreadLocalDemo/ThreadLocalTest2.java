package ThreadLocalDemo;

public class ThreadLocalTest2 {
    // JDK8中每个Thread变量中有一个ThreadLocalMap实例，Map的key是这个ThreadLocal实例，value是放的值
    // 不同的线程是不同的Thread实例，他里面包含一个ThreadLocalMap实例，保存一个map对象，key为同一个threadLocal对象，而value为保存的值
    // 理解起来就是使用Thread对象保存了我们设置的值
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("main main");
        print("main");
        threadLocal.remove();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("local A");
                print("A");
                System.out.println("after remove " + threadLocal.get()); // null
            }
        }, "thread-A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("local B");
                print("B");
                System.out.println("after remove " + threadLocal.get());
            }
        }, "thread-B").start();


    }

    private static void print(String str) {
        // 打印当前线程中本地内存中本地变量的值
        System.out.println(str + " : " + threadLocal.get());
        // 清除本地内存中的本地变量，这里涉及到内存泄露的问题 https://blog.csdn.net/u010445301/article/details/111322569
        threadLocal.remove();
    }
}
