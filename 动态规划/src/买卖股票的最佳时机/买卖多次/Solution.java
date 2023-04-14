package 买卖股票的最佳时机.买卖多次;

public class Solution {
    /*
    dp[i][0] 表示第i天持有股票所得现金。
    dp[i][1] 表示第i天不持有股票所得最多现金
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        int result = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); //是当天买的（前一天肯定不持有），还是前一天就买了（前一天肯定持有）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }
}
