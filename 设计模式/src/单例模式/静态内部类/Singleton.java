package 单例模式.静态内部类;

public class Singleton {
    //内部类延时加载，只有到使用的时候才加载，用到了类加载的机制（一个类只会被加载一次）
    //虚拟机会保证类加载是线程安全的
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        //访问一个类型的静态字段会触发类的初始化
        return SingletonHolder.instance;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("main");
        Singleton.getInstance();
    }
}
