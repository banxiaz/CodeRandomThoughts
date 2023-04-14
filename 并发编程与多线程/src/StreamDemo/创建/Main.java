package StreamDemo.创建;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 常用的方法有以下：
// 创建
// 遍历、匹配 foreach find match
// 筛选 filter
// 聚合 max min count
// 映射 map flatMap
// 归约 reduce
// 收集 collect (toList/toSet/toMap count/averaging partitioningBy/groupingBy joining reducing)
// 排序 sorted
// 提取 组合

public class Main {
    public static void main(String[] args) {
        // 1. 集合创建流
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();

        // 2. 数组创建流
        int[] array = {1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(array);

        // 3. Stream的静态方法
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        stream3.forEach(System.out::println);
    }
}
