package of42连续子数组的最大和;

public class Solution {
    //贪心算法
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            maxSum = Math.max(maxSum, count);
            if (count <= 0) { //如果当前和为负数，则从下一个数开始计算序列
                count = 0;
            }
        }
        return maxSum;
    }

    //动态规划
    public int maxSubArray2(int[] nums) {
        //dp[i]表示包括i之前的最大连续子序列和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}
