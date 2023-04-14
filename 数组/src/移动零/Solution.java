package 移动零;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                int temp = nums[fastIndex];
                nums[fastIndex] = nums[slowIndex];
                nums[slowIndex] = temp;

                slowIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 0, 3, 0, 0, 5, 6, 8};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
