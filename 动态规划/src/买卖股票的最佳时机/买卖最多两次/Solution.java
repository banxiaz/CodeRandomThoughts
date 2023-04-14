package 买卖股票的最佳时机.买卖最多两次;

public class Solution {
    //dp[i][1]:表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票，这是很容易陷入的误区。
    //第i天是有股票的，但是可以是前几天买的，也可以是当天买的，到底怎样买收益最多呢？这就需要比较和动态规划了
    //永远记住：第0天卖出股票最大收益只能为0
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0; //如果收获利润必定为负数，那么最大利润就为0
        dp[0][3] = -prices[0]; //相当于第一天又买又卖，然后第二次买入
        dp[0][4] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); //是当天买的，还是前一天就买了
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]); //是当天卖的，还是前一天就卖了
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]); //是当天买的，还是前一天就买了
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]); //是当天卖的，还是前一天就卖了
        }
        return dp[len - 1][4];
    }
}
