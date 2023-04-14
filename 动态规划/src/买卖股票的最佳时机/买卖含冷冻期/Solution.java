package 买卖股票的最佳时机.买卖含冷冻期;

public class Solution {
    /*
    [0]状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
    卖出股票状态，这里就有两种卖出股票状态
        [1]状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
        [2]状态三：今天卖出了股票
    [3]状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < n; i++) {
            //前一天就持有0 || 今天买入（前一天是1 || 前一天是3）
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            //前一天是1 || 前一天是3
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //前一天一定是0
            dp[i][2] = dp[i - 1][0] + prices[i];
            //前一天一定是2
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][3], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}
