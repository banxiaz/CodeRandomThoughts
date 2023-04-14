package of63股票买卖一次;

public class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][0]持有
        //dp[i][1]不持有
        if (prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}
