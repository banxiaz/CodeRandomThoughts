package 计数排序;

import java.util.Arrays;

public class CountingSort {
    /**
     * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中
     * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数
     * 当输入的元素是 n 个 0 到 k 之间的整数时，它的运行时间是 O(n + k)
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4, 4, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序
     * 默认数据范围大于0，如果有小于0的数据，换一种排序算法或者使用map
     * 1.找到数组中最大的元素值，并且初始化一个 最大值+1 长度的数组，用来存储每个元素出现的次数，索引表示待排序数组的值，而索引处的值表示数出现的次数，所以叫计数排序
     * 2.
     * @param arr
     */
    public static void sort(int[] arr) {
        int maxValue = arr[0]; //找到元素的最大值，默认所有的值全部不小于0，否则数组越界，且数值不应该过于大，否则数组长度太大了
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }
        System.out.println(Arrays.toString(bucket));

        int sortedIndex = 0;
        for (int i = 0; i < bucketLen; i++) { //遍历计数数组
            while (bucket[i] > 0) { //只要数组的值不为0，就可以不停的取值
                arr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
    }
}
