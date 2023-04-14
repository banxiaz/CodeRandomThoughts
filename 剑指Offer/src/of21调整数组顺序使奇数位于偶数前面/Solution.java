package of21调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

public class Solution {
    //一次快排
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //向右移动left，直到它指向偶数跳出循环
            while (left < right && ((nums[left] & 0x1) != 0)) {
                left++;
            }
            //向左移动right，直到它指向奇数跳出循环
            while (left < right && (nums[right] & 0x1) == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }
}
