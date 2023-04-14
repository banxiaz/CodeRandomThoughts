package 买卖股票的最佳时机.买卖含手续费;

public class Solution {
    //相比买卖多次就多了一个手续费而已
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        int result = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); //是当天买的（前一天肯定不持有），还是前一天就买了（前一天肯定持有）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[length - 1][1];
    }
}
