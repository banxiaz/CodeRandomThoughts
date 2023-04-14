package 较难动态规划.石子游戏;

public class Solution {
    public boolean stoneGame(int[] piles) {
        //dp[i][j][0]表示对于[i, j]这部分石头，先手能获得的最高分数为dp[i][j][0]
        //dp[i][j][1]表示对于[i, j]这部分石头，后手能获得的最高分数为dp[i][j][1]

        //我作为先手，面对 piles[i...j] 时，有两种选择：
        //- 要么我选择最左边的那⼀堆⽯头，然后⾯对 piles[i+1...j]，但是此时轮到对⽅，相当于我变成了后⼿；
        //- 要么我选择最右边的那⼀堆⽯头，然后⾯对 piles[i...j-1]，但是此时轮到对⽅，相当于我变成了后⼿。

        //我作为后⼿，要等先⼿先选择，有两种情况：
        //- 如果先⼿选择了最左边那堆，给我剩下了 piles[i+1...j]，此时轮到我，我变成了先⼿；
        //- 如果先⼿选择了最右边那堆，给我剩下了 piles[i...j-1]，此时轮到我，我变成了先⼿。

        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0; //只有一堆石头，后手获得不了分数
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 先⼿选择最左边或最右边的分数
                int left = piles[i] + dp[i + 1][j][1];
                int right = piles[j] + dp[i][j - 1][1];

                // 先⼿肯定会选择更⼤的结果，后⼿的选择随之改变
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }

        return dp[0][n - 1][0] >= dp[0][n - 1][1];
    }
}
