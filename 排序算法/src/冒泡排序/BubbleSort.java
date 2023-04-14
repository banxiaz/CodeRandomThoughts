package 冒泡排序;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { //一共需要循环 n-1 次，因为n-1个排好序之后，最后一个肯定已经排好了
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) { //从0开始，到n-i结束，因为是j+1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            }
        }
    }
}
