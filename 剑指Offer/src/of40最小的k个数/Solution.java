package of40最小的k个数;


import java.util.Arrays;

public class Solution {
    //这种方法需要修改元素数组,参考快速排序思想，但是会超时！！！
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k <= 0) {
            return new int[]{};
        }

        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, start, end);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int key = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= key) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new Solution().getLeastNumbers(nums, 5)));
        System.out.println(Arrays.equals(new int[0], new int[]{}));
    }
}
