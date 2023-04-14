package 插入排序;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int temp = arr[i];
            // 从已经排序的序列与右边的第一个数开始比较，找到比右边的第一个数小的数
            int j = i - 1; //j是第一个待比较的元素
            while (j >= 0 && temp < arr[j]) { //j>=0为什么？ j=0不会越界
                arr[j + 1] = arr[j]; //把大于插入元素的向右移动
                j--; //每次赋值之后j移位
            }
            // 存在比其小的数，插入点是 j+1
            if (j + 1 != i) {
                arr[j + 1] = temp;
            }
        }
    }
}
