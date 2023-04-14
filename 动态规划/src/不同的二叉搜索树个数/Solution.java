package 不同的二叉搜索树个数;

public class Solution {
    //i个不同元素节点组成的二叉搜索树的个数为dp[i]
    //dp[1]+=dp[0]*dp[0]
    //dp[2]+=dp[0]*dp[1] dp[2]+=dp[1]*dp[0]
    //dp[3]+=dp[0]*dp[2] dp[3]+=dp[1]*dp[1] dp[3]+=dp[2]*dp[0]
    //dp[4]+=dp[0]*dp[3] dp[4]+=dp[1]*dp[2] dp[4]+=dp[2]*dp[1] dp[4]+=dp[3]*dp[0]
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //节点数量 = 1 + 左子树 + 右子树
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j]; //减1减的是根节点
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(5));
    }
}
