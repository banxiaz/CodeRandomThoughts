package 单例模式.懒汉式线程安全;

public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("main");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
    }
}
