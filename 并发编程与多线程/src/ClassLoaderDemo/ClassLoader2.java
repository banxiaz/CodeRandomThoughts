package ClassLoaderDemo;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class ClassLoader2 {
    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException {
        ClassLoader classLoader = ClassLoader2.class.getClassLoader();
        System.out.println(classLoader);
        // getResource
        // loadClass


    }
}
