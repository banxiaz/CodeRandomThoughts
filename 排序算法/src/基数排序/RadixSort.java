package 基数排序;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 100};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int maxDigit = getMaxDigit(arr);
        System.out.println(maxDigit);
        radixSort(arr, maxDigit);

    }

    public static int getMaxDigit(int[] arr) { //获得最大的数有几位
        int maxValue = getMaxValue(arr);
        int numLength = getNumLength(maxValue);
        return numLength;

    }

    private static int getMaxValue(int[] arr) { //找最大的数
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected static int getNumLength(long num) { //计算数num有几位
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    public static void radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                // int bucket = ((arr[j] % mod) / dev) + mod;
                int bucket = ((arr[j] / dev) % mod) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value; //出队列
                }
            }
        }
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}

