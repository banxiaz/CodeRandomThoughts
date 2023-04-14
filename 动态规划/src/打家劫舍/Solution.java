package 打家劫舍;

public class Solution {
    // 打家劫舍，经典题目
    // dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
    // 如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i]
    // 如果不偷第i房间，那么dp[i] = dp[i - 1]
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
