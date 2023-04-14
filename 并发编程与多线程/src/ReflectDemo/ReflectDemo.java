package ReflectDemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TargetObject {
    private String value;

    public TargetObject() {
        value = "hello";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    public void privateMethod() {
        System.out.println("value is " + value);
    }

    @Override
    public String toString() {
        return "TargetObject{" +
                "value='" + value + '\'' +
                '}';
    }
}


public class ReflectDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> targetClass = TargetObject.class;
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        // 获取 TargetObject 类中定义的所有方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        // 获取指定方法并调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "hello hello");

        // 获取指定参数并对参数进行修改
        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "hihi");
        System.out.println(targetObject);

        // 调用 private 方法
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
