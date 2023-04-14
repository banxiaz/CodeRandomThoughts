package 最大子序和;

public class Solution {
    //找到一个具有最大和的连续子数组，
    //dp[i]：包括下标i之前的最大连续子序列和为dp[i]，dp[i]有两个方向推导：
    //1. dp[i-1]+nums[i]    要么从前一个传递
    //2. nums[i]            要么从头开始
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
