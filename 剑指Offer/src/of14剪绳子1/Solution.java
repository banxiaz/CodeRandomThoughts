package of14剪绳子1;

public class Solution {
    //此题与LC343完全相同，为什么还是不会呢？
    public int cuttingRope(int n) {
        //dp[i] 把长度为i的绳子切割若干段后相乘得到的最大值
        // 第一种情况是当前面 i - j 个长度的绳子被割过时，此时乘积为 dp[i - j] * j
        // 第二种情况是前面 i - j 个绳子没有被割过时，此时的乘积为 (i - j) * j
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //将i-j分为两段或者多段，哪个最大呢？需要动态规划
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}
