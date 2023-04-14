package 最大子序和;

public class Solution {
    //局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”
    //因为负数加上下一个元素 “连续和”只会越来越小
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count; // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            }
            if (count <= 0) { // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
                count = 0;
            }
        }
        return result;
    }

    //动态规划
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length]; // dp[i]表示包括i之前的最大连续子序列和
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); //要么nums[i]和前面数字连续，要么从nums[i]开始
            if (result > dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray2(new int[]{-1, -1, -1}));
    }
}
