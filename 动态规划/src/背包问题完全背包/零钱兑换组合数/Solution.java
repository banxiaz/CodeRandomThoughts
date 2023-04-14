package 背包问题完全背包.零钱兑换组合数;

public class Solution {
    //求组合数：外层硬币，内层金额，完全背包问题。
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) { //物品
            for (int j = coins[i]; j <= amount; j++) { //背包
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}

