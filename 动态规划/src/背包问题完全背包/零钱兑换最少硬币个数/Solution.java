package 背包问题完全背包.零钱兑换最少硬币个数;

import java.util.Arrays;

public class Solution {
    // dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        Arrays.fill(dp, max);
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要，否则会产生数字越界的错误
                // 如果dp[j - coins[i]]是初始值则跳过
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        System.out.println(new Solution().coinChange(coins, 4));
    }
}
