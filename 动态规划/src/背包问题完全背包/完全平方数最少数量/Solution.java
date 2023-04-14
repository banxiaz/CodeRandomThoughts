package 背包问题完全背包.完全平方数最少数量;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max);
        //当和为0时，组合的个数为0
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) { //遍历物品
            for (int j = i * i; j <= n; j++) { //遍历背包容量
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
