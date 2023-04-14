package ConcurrentHashMapDemo;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap1 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("one", 1);
        // 如果不存在（新的entry），那么会向map中添加该键值对，并返回null
        // 如果已经存在，那么不会覆盖已有的值，直接返回已经存在的值
        System.out.println(map.putIfAbsent("two", 2));
        System.out.println(map.putIfAbsent("one", 3));
        System.out.println(map.get("one"));
        System.out.println(map.containsKey("one"));
    }
}
