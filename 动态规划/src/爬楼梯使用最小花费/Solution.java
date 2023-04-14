package 爬楼梯使用最小花费;

import java.util.Arrays;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //需要多定义一阶楼梯代表楼顶
        //dp[i]表示我站在楼梯i，现在已经花费的最小费用是dp[i]
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }
}
