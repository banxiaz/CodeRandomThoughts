package 滑动窗口长度最小的子数组;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;    // 滑动窗口数值之和
        int i = 0;      // 滑动窗口起始位置
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= target) {
                res = Math.min(res, j - i + 1);  // 取子序列的长度
                sum -= nums[i++];                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
