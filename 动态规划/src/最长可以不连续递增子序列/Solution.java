package 最长可以不连续递增子序列;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始时每一个序列都是自身递增
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                //必须满足递增序列
                if (nums[j] < nums[i]) {
                    //初始时dp[i]=1，然后不断更新为最大递增子序列长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
