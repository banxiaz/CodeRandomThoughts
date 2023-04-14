package 整数拆分;

public class Solution {
    //2 <= n <= 58
    public int integerBreak(int n) {
        //dp[i]为正整数i拆分结果的最大乘积。0 1不需要初始化，因为没有意义。
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //j = [1, 2, ..., i-1]用来拆分
            for (int j = 1; j < i; j++) {
                //j*(i-j)代表把i拆分为j和i-j两个数相乘
                //j*dp[i-j]代表把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
                //在这个for循环中也要不断更新dp[i]的值
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
