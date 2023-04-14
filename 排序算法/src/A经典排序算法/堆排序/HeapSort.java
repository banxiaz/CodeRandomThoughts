package A经典排序算法.堆排序;

import java.util.Arrays;

public class HeapSort {
    public void sort(int[] arr) {
        int len = arr.length;
        //建堆O(nlogn)
        buildMaxHeap(arr, len);

        //调堆O(n)
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
    }

    //索引【i】的父节点为 (i-1)/2
    //找到第一个非叶子节点i，并且从第一个非叶子结点开始，从后向前遍历所有的非叶子节点
    public void buildMaxHeap(int[] arr, int len) {
        for (int i = (len - 1 - 1) / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {8, 7, 6, 5, 4, 9, 3, 2, 1, 0};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
