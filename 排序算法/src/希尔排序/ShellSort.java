package 希尔排序;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 6, 3, 0, 8, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int temp;
        for (int step = len / 2; step >= 1; step /= 2) { //选择一个初始增量，每次除以2，直到减小到为1即变为原始的【插入排序】
            for (int i = step; i < len; i++) { //从每个增量的第2个元素开始，直到arr最后一个元素
                temp = arr[i];
                int j = i - step; //第一个要比较的元素，且此时j不是插入位置，j+step才是要插入的位置
                while (j >= 0 && arr[j] > temp) {//在一个增量里面比较
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp; //插入点是j+step，这里一定要搞明白为什么
                //最后一次进while循环，会将j的值错1位，当不满足while循环的时候，j是偏了一位的
                //具体的差异可以看插入排序
            }
        }
    }
}

