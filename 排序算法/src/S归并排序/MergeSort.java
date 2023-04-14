package S归并排序;

import java.util.Arrays;

public class MergeSort {
    /**
     * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
     * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之
     * 归并排序算法有两个基本的操作，一个是分，也就是把原数组划分成两个子数组的过程。另一个是治，它将两个有序数组合并成一个更大的有序数组。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {8, 1, 4, 9, 0, 3, 5, 2, 7, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length]; //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sortStart(arr, 0, arr.length - 1, temp);
    }

    //递归函数作用：使得在[left,right]范围内的子序列有序
    public static void sortStart(int[] arr, int left, int right, int[] temp) {
        if (left < right) { //分的条件,即 子数组的长度==1 结束递归，而len=right-left+1>1，即left<right
            int mid = (left + right) / 2;
            sortStart(arr, left, mid, temp); //分左边，使得左子序列有序,注意这里没有加1，与快速排序区分开来，快速排序每一次排好一个位置i，i左边的小于参考，i右边的大于参考，所以不用排i
            sortStart(arr, mid + 1, right, temp); //右边分，使得右子序列有序
            merge(arr, left, mid, right, temp); //将两个有序子数组合并操作，治
        }
        //还有一种写法
        //if(right-left+1==1)
        //  return; 即显式的return
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左序列指针
        int j = mid + 1; //右序列指针
        int t = 0; //临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) { //必有一个不会进循环，这里这样写可以不用if来判断，简化判断，因为上面while跳出的标志与下面有重合关系
            temp[t++] = arr[i++];
        }
        while (j <= right) { //必有一个不会进循环，这里这样写可以不用if来判断，简化判断
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
