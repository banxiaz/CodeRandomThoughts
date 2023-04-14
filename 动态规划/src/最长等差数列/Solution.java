package 最长等差数列;

public class Solution {
    public int longestArithSeqLength(int[] nums) {
        // dp[i][j]表示以数组下标i处的元素结尾，公差为j的等差数列的最大长度
        // 状态转移方程：dp[k][d] = dp[j][d] + 1, if nums[k] - d == nums[j]
        // 初始化，其实dp数组每个位置应该赋值为1，因为只包含自己的数组的长度只能是1
        // 但是这里我们可以不赋值为1，但是在返回结果的时候+1就行了

        int n = nums.length;
        int[][] dp = new int[n][1001];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = dp[j][d] + 1;
                res = Math.max(res, dp[i][d]);
            }
        }
        return res + 1;
    }
}
