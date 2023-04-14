package 桶排序;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int bucketSize = 3;
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            } else if (minValue > value) {
                minValue = value;
            }
        }
        System.out.println("max" + maxValue + "|" + "min" + minValue);

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0]; //初始化为0，后面自动扩容

        //利用映射函数将数据分配到各个桶中
        for (int j : arr) {
            int index = (int) Math.floor((j - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], j);
        }
        System.out.println(Arrays.deepToString(buckets));

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length == 0) {
                continue;
            }
            Arrays.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
    }

    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
