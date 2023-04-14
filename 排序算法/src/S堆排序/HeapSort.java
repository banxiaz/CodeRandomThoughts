package S堆排序;

import java.util.Arrays;

public class HeapSort {
    /**
     * 堆排序是一种选择排序
     * 它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
     *
     * @param args
     */
    // 如果是在建好的堆中，再插入一个元素，只能插入到数组的末尾，然后将这个节点和它的根节点比较，交换后依次与根节点比较。
    public static void main(String[] args) {
        // int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        int len = arr.length;

        buildMaxHeap(arr, len); //第一次建堆的过程
        System.out.println(Arrays.toString(arr)); //876345210 建好了堆
        for (int i = len - 1; i > 0; i--) { //下面就开始调整堆，调整堆的过程也就是排序的过程
            swap(arr, 0, i);
            System.out.println(Arrays.toString(arr));
            len--;
            //这里只需要进行大顶堆的调整即可 为什么？
            //因为第一次建立堆，交换首尾元素之后，其他元素还是满足大顶堆的性质
            //此时只需要从根节点开始，选择出左右孩子节点较大的那一分支进行调整，而另一分支不用管，并且不用从最后一个非叶子结点开始
            heapify2(arr, 0, len);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 从初始无序堆到第一次构建大顶堆
     * i 的父节点为 (i-1)/2 ，i为索引
     *
     * @param arr 待排序堆
     * @param len 待排序长度
     *            1. 找到第一个非叶子节点，并且从第一个非叶子结点开始，从后向前遍历所有的非叶子节点
     *            2. 在这个方法期间，len是不变的
     */
    public static void buildMaxHeap(int[] arr, int len) {
        for (int i = (len - 1 - 1) / 2; i >= 0; i--) {
            heapify2(arr, i, len);
        }
    }

    /**
     * 以i为根节点，以len为待排序长度的子树，交换根节点和孩子节点的过程，即构建大顶堆
     *
     * @param arr 待排序堆
     * @param i   当前非叶子节点
     * @param len 待排序长度，不会变
     */
    public static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1; //左孩子
        int right = 2 * i + 2; //右孩子
        int largest = i; //找父节点左孩子右孩子最大的

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) { //不相等才进行交换，而一旦交换就需要调整孩子节点
            swap(arr, i, largest);
            //交换之后可能会导致大顶堆的性质失效，需要重新从被交换的那一个分支调整堆，另一个分支不用管
            //以largest为根节点，递归调用heapify
            //也有迭代写法，相对来说较复杂
            heapify(arr, largest, len);
        }
    }

    public static void heapify2(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int left = 2 * i + 1; left < len; left = 2 * left + 1) {
            // 在左右孩子中找到较大的一个节点，用left记录
            if (left + 1 < len && arr[left] < arr[left + 1]) {
                left++;
            }
            // 再和根节点比较
            if (arr[left] > temp) {
                arr[i] = arr[left]; //把最大的放在根节点上
                arr[left] = temp; // 把原来根节点的放在当前位置上
                i = left; // 更新下一个根节点
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

