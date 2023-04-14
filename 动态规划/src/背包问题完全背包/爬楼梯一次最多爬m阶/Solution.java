package 背包问题完全背包.爬楼梯一次最多爬m阶;

public class Solution {
    //求排列数，总和放在外层
    //一次最多可以爬m阶
    public int climbStairs(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) { //先背包
            for (int j = 1; j <= m; j++) { //后物品
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(10, 2));
    }
}
