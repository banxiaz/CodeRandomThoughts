package S快速排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4};
        // quickSort(arr,0, arr.length-1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) { //即 子数组的长度==1 结束递归，而len=right-left+1>1，即left<right
            int partitionIndex = partition(arr, left, right); //获取排好的那一个位置partitionIndex
            quickSort(arr, left, partitionIndex - 1); //排左边
            quickSort(arr, partitionIndex + 1, right); //排右边
        }
    }

    //只排left与right之间的，这种写法简单好记
    public static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int key = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= key) { //先从右边开始与key比较，如果array[j]>key，说明位置正确，j--，否则位置不正确退出
                j--;
            }
            arr[i] = arr[j]; //将array[i]=array[j]

            while (i < j && arr[i] <= key) { //再从左边开始与key比较，如果array[i]<key，说明位置正确，i++，否则位置不正确退出
                i++;
            }
            arr[j] = arr[i]; //将array[j]=array[i]
        }

        arr[i] = key; //循环终止，i==j，array[i]=key，此时i位置的已经排好了
        return i;
    }

/*
    public static int anotherPartition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int key = arr[left];
        while (i < j) { //or i != j
            while (i < j && arr[j] > key) { //先从右边开始与key比较，如果array[j]>key，说明位置正确，j--，否则位置不正确退出
                j--;
            }
            if (i < j) { //将array[i]=array[j]，左边i++
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < key) { //再从左边开始与key比较，如果array[i]<key，说明位置正确，i++，否则位置不正确退出
                i++;
            }
            if (i < j) { //将array[j]=array[i]，右边j--
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = key; //循环终止，i==j，array[i]=key，此时i位置的已经排好了
        return i;
    }
*/
}


