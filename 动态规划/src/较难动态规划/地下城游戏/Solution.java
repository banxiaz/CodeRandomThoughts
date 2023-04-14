package 较难动态规划.地下城游戏;

import java.util.Arrays;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        //dp[i][j]表示从(i, j)出发到达终点的最少生命值是dp[i][j]
        //假设当前位置需要的血量为y(>=1)，当前位置的状态为x(有正有负)，到达终点需要的状态为z，可以推出：y+x=z
        //y > 0 表示需要y的血量，才能到达z
        //y = 0 表示可以不需要y的血量，但是血量必须至少为1
        //y < 0 表示当前血量甚至有点多了，但是血量必须至少为1

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : -dungeon[m - 1][n - 1] + 1;  //骑士任一时刻点数大于0
        for (int i = m - 2; i >= 0; i--) {
            int need = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = need > 0 ? need : 1;
        }
        for (int j = n - 2; j >= 0; j--) {
            int need = dp[m - 1][j + 1] - dungeon[m - 1][j];
            dp[m - 1][j] = need > 0 ? need : 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = dp[i][j] > 0 ? dp[i][j] : 1;
            }
        }
        return dp[0][0];
    }
}
