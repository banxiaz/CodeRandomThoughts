package A经典排序算法.快速排序;


import java.util.Arrays;

//递归求解子问题，前序遍历
public class QuickSort {
    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        sort(arr, left, index - 1);
        sort(arr, index + 1, right);
    }

    public int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int key = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= key) {
                i++;
            }
            arr[j] = arr[i];
        }
        //当循环终止时满足i == j，设置array[i]=key，表明此时i/j位置的已经排好，key已经被放到了正确的位置
        arr[i] = key;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
