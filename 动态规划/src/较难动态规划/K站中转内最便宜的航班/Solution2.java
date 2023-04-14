package 较难动态规划.K站中转内最便宜的航班;

import java.util.Arrays;

public class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //dp[i][j]表示恰好通过i次航班，从出发城市src到达j需要的最小花费，结果为dp[1][dst],dp[2][dst],...dp[k+1][dst]中的最小值
        //遍历最后一次航班的所有起点temp，将路线变为从src到temp，再从temp到i，取其中的最小值
        //dp[i][j] =min[t, i in flight]{ dp[i-1][t] + cost(t, i) }

        int INF = 10000 * 101 + 1;

        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], INF); // 初始化为最大值
        }
        dp[0][src] = 0; //通过0次航班从src到src的花费为0
        for (int i = 1; i < k + 2; i++) {
            for (int[] flight : flights) { //遍历所有的航班，取花费最小的
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
            }
        }

        int ans = INF;
        for (int i = 1; i <= k + 1; i++) {
            ans = Math.min(ans, dp[i][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}
