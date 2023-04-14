package 较难动态规划.规定时间内到达终点的最小花费;

import java.util.Arrays;

public class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        // dp[i][j] 代表恰好使用i分钟，从出发城市到达j需要的最少通行费总合

        int MAX = 1000 * 1000 + 1;
        int[][] dp = new int[maxTime + 1][passingFees.length];
        for (int i = 0; i < maxTime + 1; i++) {
            Arrays.fill(dp[i], MAX);
        }
        dp[0][0] = passingFees[0]; //从出发到出发需要passingFees[0]费用

        for (int i = 1; i < maxTime + 1; i++) {
            for (int[] edge : edges) {
                int city1 = edge[0];
                int city2 = edge[1];
                int costTime = edge[2];
                if (costTime <= i) {
                    // 因为是双向的，表示两个城市之间有一条边，没有起点和终点之分，所以都需要遍历
                    dp[i][city1] = Math.min(dp[i][city1], dp[i - costTime][city2] + passingFees[city1]);
                    dp[i][city2] = Math.min(dp[i][city2], dp[i - costTime][city1] + passingFees[city2]);
                }
            }
        }

        int res = MAX;
        for (int i = 1; i < maxTime + 1; i++) {
            res = Math.min(res, dp[i][passingFees.length - 1]);
        }
        return res == MAX ? -1 : res;
    }

    public static void main(String[] args) {
        int maxTime = 30;
        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        System.out.println(new Solution().minCost(maxTime, edges, passingFees));
    }
}
