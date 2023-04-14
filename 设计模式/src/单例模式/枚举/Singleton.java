package 单例模式.枚举;

public enum Singleton {
    //枚举成员默认是 public static final
    //每一个成员都是这个类的一个实例
    instance;

    public Singleton getInstance() {
        System.out.println(instance.getClass().getName());
        return instance;
    }
}

class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance;
        System.out.println(singleton);
        singleton.getInstance();
    }
}
