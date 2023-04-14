package StreamDemo.数组排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 4, 3};
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);

        // 数组逆序排序
        int[] nums2 = {1, 5, 2, 4, 3};
        int[] res = IntStream.of(nums2).boxed().sorted((o1, o2) -> o2 - o1).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(res));

        String[] strings = {"A", "E", "B", "D", "C"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, Comparator.reverseOrder());
        System.out.println(Arrays.toString(strings));
    }
}
