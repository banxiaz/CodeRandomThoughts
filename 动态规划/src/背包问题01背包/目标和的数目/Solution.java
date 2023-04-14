package 背包问题01背包.目标和的数目;

public class Solution {
    //dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
    //在求装满背包有几种方法的情况下，递推公式一般为：dp[j] += dp[j - nums[i]];
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //划分出来不是整数，没有方案
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        //即使全是正数或者全是负数，都达不到要求，也没有方案
        if (Math.abs(target) > sum) {
            return 0;
        }

        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        //装满容量为0的背包只有一种方案，那就是什么也不装
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
