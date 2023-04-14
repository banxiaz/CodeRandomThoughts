package 最长必须连续递增子序列;

import java.util.Arrays;

public class Solution {
    //dp[i]：以下标i为结尾的数组的连续递增的子序列长度为dp[i]。
    //要求连续，那么就比较相邻两个序列
    //1 <= nums.length <= 10^4
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
