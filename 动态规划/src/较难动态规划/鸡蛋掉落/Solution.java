package 较难动态规划.鸡蛋掉落;

public class Solution {
    public int superEggDrop(int k, int n) {
        //dp(k, n) k为鸡蛋数，n为楼层数，当我们从x楼扔鸡蛋时：
        //- 鸡蛋碎了，状态变为dp(k-1, x-1), 答案只可能在第 x 楼下方的 x-1层中了
        //- 鸡蛋没碎，状态变为dp(k, n-k)，答案只能在上方的n-x层楼中了
        // dp(k, n) = 1 + min(max(dp(k-1, x-1), dp(k, n-x)) 其中 1<= x <= n

        //https://www.bilibili.com/video/BV1KE41137PK

        //dp[i][j]表示在i层楼和j个鸡蛋的情况下，最小操作次数为dp[i][j]
        int[][] dp = new int[n + 1][k + 1];

        //在只有1个鸡蛋时，需要从1开始递增次数，最小操作数在最坏情况下就是楼层数
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        //在只有1层楼时，不管有多少个鸡蛋，都只需要1次
        for (int j = 1; j <= k; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = n * k;
                for (int c = 1; c < i; c++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[c - 1][j - 1], dp[i - c][j]));
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop(3, 14));
    }
}
