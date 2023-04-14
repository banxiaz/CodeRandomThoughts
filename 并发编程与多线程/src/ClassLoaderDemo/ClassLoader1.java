package ClassLoaderDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassLoader1 extends ClassLoader {
    private final String classPath;

    public ClassLoader1(String classPath) {
        this.classPath = classPath;
    }

    public static void main(String[] args) throws Exception {
        // 除了 BootstrapClassLoader 其他类加载器均由 Java 实现且全部继承自java.lang.ClassLoader。如果我们要自定义自己的类加载器，很明显需要继承 ClassLoader
        System.out.println("[ClassLoader1's ClassLoader is]" + ClassLoader1.class.getClassLoader());
        System.out.println("[The Parent of ClassLoader1's ClassLoader is] " + ClassLoader1.class.getClassLoader().getParent());
        System.out.println("[The GrandParent of ClassLoader1's ClassLoader is] " + ClassLoader1.class.getClassLoader().getParent().getParent());

        // 如果想破坏双亲委派的话，就重写loadClass方法；
        // 如果想用自定义的类加载器就重写findClass方法，不能被父类加载器加载的类最终会通过这个方法被加载
        // 需要加载的类不能放在AppClassLoader可以加载的位置，否则会被AppClassLoader默认加载而不能走自定义的类加载器
        // 名字这个地方：不写package就是默认，写了package就需要从package ...开始导入
        System.out.println();
        ClassLoader1 myClassLoader = new ClassLoader1("D:\\Algorithm\\CodeRandomThoughts\\picture");
        Class<?> aClass = myClassLoader.loadClass("Test"); // loadClass -> findClass 这里的名字要用全限定名
        aClass.getDeclaredMethod("say").invoke(aClass);
        Object o = aClass.newInstance();
        Method print = aClass.getDeclaredMethod("print", String.class);
        print.invoke(o, "打印");
        System.out.println(aClass.getClassLoader()); // ClassLoaderDemo.ClassLoader1@4554617c
        System.out.println(aClass.getClassLoader().getParent()); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(aClass.getClassLoader().getParent().getParent()); // sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println(aClass.getClassLoader().getParent().getParent().getParent()); // null

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = loadByte(name);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String className) throws IOException {
        String fileName = classPath + File.separator + className.replace(",", File.separator).concat(".class");
        // String fileName = "D:\\Algorithm\\CodeRandomThoughts\\picture\\Test.class";
        System.out.println("将要加载：" + fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] bytes = new byte[fileInputStream.available()];
        int len = fileInputStream.read(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(len);

        fileInputStream.close();
        return bytes;
    }
}
