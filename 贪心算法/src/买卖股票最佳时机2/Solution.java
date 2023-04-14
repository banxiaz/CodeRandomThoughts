package 买卖股票最佳时机2;

public class Solution {
    /*
    可以尽可能地完成更多的交易.但你不能同时参与多笔交易
    把利润分解为每天为单位的维度，而不是从i天到第j天整体去考虑！
    其实我们需要收集每天的正利润就可以，收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间。
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        // dp[i][0]第i天持有股票后的最多现金
        // dp[i][1]第i天不持有股票后的最多现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天持有=max(第i-1天就持有，第i-1天不持有i天买入)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //第i天不持有=max(第i-1天就不持有，第i-1天持有今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
