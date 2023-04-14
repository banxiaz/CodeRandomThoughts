package 后面数减前面数最大值;

public class Solution {
    public int getMaxValue(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int minNum = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, nums[i] - minNum); //先计算结果
            minNum = Math.min(minNum, nums[i]); //后更新最小值，防止数组单调递减而结果总是为0
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4};
        System.out.println(new Solution().getMaxValue(nums));
    }
}
