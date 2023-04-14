package UnsafeDemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Unsafe1 {
    static class Target {
        public int value = 10;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field valueField = Target.class.getDeclaredField("value");
        Target target = new Target();
        System.out.println("原始值：" + valueField.get(target));

        Unsafe unsafe = getUnsafe();
        assert unsafe != null;
        final long valueOffset = unsafe.objectFieldOffset(valueField);
        // 当前对象，偏移量获取需要修改的变量，期望值，修改后的新值，当且仅当期望值等于内存中的值时，将变量修改为新值
        System.out.println("第一次swap(10, 20)函数返回值：" + unsafe.compareAndSwapInt(target, valueOffset, 10, 20));
        System.out.println("第一次swap（10, 20)后value值：" + valueField.get(target));

        System.out.println("第二次swap(10, 20)函数返回值：" + unsafe.compareAndSwapInt(target, valueOffset, 10, 20));
        System.out.println("第二次swap（10, 20)后value值：" + valueField.get(target));


    }

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

